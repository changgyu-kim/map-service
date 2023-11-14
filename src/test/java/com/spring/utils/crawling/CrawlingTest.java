package com.spring.utils.crawling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Store;
import com.spring.repository.StoreRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
class CrawlingTest {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    void 카카오API_주소로_위도경도구하기_성공() throws URISyntaxException, UnsupportedEncodingException, JsonProcessingException {
        // Kakao API 키를 설정합니다.
        String REST_API_KEY = "46214ea45c00cb5faca592370d02aa07";
        String address = URLEncoder.encode( "전북 익산시 삼성동 100", StandardCharsets.UTF_8.toString());

        // RestTemplate 인스턴스를 생성합니다.
        RestTemplate rt = new RestTemplate();

        // HttpHeaders를 설정합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + REST_API_KEY);

        // URI를 설정합니다.
        URI uri = new URI("https://dapi.kakao.com/v2/local/search/address.json?query=" +
                    address);

        // Http 요청을 수행하고 응답을 받습니다.
        ResponseEntity<String> response = rt.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );

        // JSON 파싱을 위해 ObjectMapper를 생성합니다.
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON을 읽어 JsonNode로 변환합니다.
        JsonNode jsonNode = objectMapper.readTree(response.getBody());


        // 첫 번째 주소의 "x"와 "y" 값을 추출합니다.
        String firstX = jsonNode.path("documents").path(0).path("address").path("x").asText();
        String firstY = jsonNode.path("documents").path(0).path("address").path("y").asText();

        // 추출한 값 출력
        System.out.println("경도 : " + firstX + ", 위도 : " + firstY);

    }

    static List<Store> storeList = new ArrayList<>();
    @Test
    void 데이터크롤링_성공() throws Exception {
        Path path = Paths.get(System.getProperty("user.dir"),"src/main/resources/driver/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", path.toString());
        String url = "https://www.goodprice.go.kr/search/goodstore.do";
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        Document tmpDocument = Jsoup.parse(driver.getPageSource());
        Elements pageElements = tmpDocument.getElementsByClass("left_text");
        int startIndex = pageElements.text().indexOf("/")+1;

        try {
            int totalPages = Integer.parseInt(pageElements.text().substring(startIndex).trim());

            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {

                // 해당 페이지 크롤링
                crawlPage(driver);

                // 다음 페이지로 이동
                goToNextPage(driver,currentPage+1);
            }
        } finally {
            storeRepository.insertList(storeList);
            driver.quit();
        }

    }
    private static void crawlPage(ChromeDriver driver) throws Exception {

        // 여기서 Jsoup을 사용하여 현재 페이지의 HTML을 가져올 수 있습니다.
        Document document = Jsoup.parse(driver.getPageSource());

        // 3. 해당 url의 html 파싱.
        Elements noElements = document.getElementsByClass("board_one");
        Elements sortElements = document.getElementsByClass("board_two");
        Elements nameElements = document.getElementsByClass("board_three");
        Elements mainMenuElements = document.getElementsByClass("board_four");
        Elements priceElements = document.getElementsByClass("board_five");
        Elements numberElements = document.getElementsByClass("board_six");
        Elements adressElements = document.getElementsByClass("board_seven");

        // 4. 출력
        printElementsInSequence(noElements, sortElements, nameElements, mainMenuElements, priceElements, numberElements, adressElements);
    }

    private static void goToNextPage(ChromeDriver driver, int nextpage) {
        int nextPage = nextpage; // 다음 페이지 번호 설정

        // 페이지 이동을 위한 JavaScript 실행
        String jsScript = "fn_egov_select_storeList(" + nextPage + ")";
        driver.executeScript(jsScript);

        // WebDriverWait를 사용하여 페이지 로딩이 완료될 때까지 대기
        WebDriverWait wait = new WebDriverWait(driver, 10); // 최대 10초 대기
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board_one")));
    }

    private static void printElementsInSequence(Elements... elementsArray) throws Exception {
        int maxElements = 0;
        for (Elements elements : elementsArray) {
            maxElements = Math.max(maxElements, elements.size());
        }

        for (int i = 1; i < maxElements; i++) {
            List htmlList = new ArrayList();

            for (Elements elements : elementsArray) {
                if (i < elements.size()) {
                    Element currentElement = elements.get(i);
                    htmlList.add(currentElement.text());
                }
            }
            // 여기서 지오코딩으로 주소 받아서 위도경도 만들어야함
            List<String> latLng = getLatLng((String) htmlList.get(6));

            Store store = new Store(Integer.parseInt((String) htmlList.get(0)),(String)htmlList.get(1),(String)htmlList.get(2),(String)htmlList.get(3),(String)htmlList.get(4),(String)htmlList.get(5),(String)htmlList.get(6),latLng.get(0),latLng.get(1));
            System.out.println(store.getId());
            System.out.println(store.getName());
            System.out.println(store.getAddress());
            storeList.add(store);
        }
    }
    private static List<String> getLatLng(String address) throws Exception {

        List<String> latLngList = new ArrayList<>();

        // Kakao API 키를 설정합니다.
        String REST_API_KEY = "46214ea45c00cb5faca592370d02aa07";
        String encodedaddress = URLEncoder.encode( address, StandardCharsets.UTF_8.toString());

        // RestTemplate 인스턴스를 생성합니다.
        RestTemplate rt = new RestTemplate();

        // HttpHeaders를 설정합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + REST_API_KEY);

        // URI를 설정합니다.
        URI uri = new URI("https://dapi.kakao.com/v2/local/search/address.json?query=" +
                encodedaddress);

        // Http 요청을 수행하고 응답을 받습니다.
        ResponseEntity<String> response = rt.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );

        // JSON 파싱을 위해 ObjectMapper를 생성합니다.
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON을 읽어 JsonNode로 변환합니다.
        JsonNode jsonNode = objectMapper.readTree(response.getBody());


        // 첫 번째 주소의 "x"와 "y" 값을 추출합니다.
        String firstX = jsonNode.path("documents").path(0).path("address").path("x").asText();
        String firstY = jsonNode.path("documents").path(0).path("address").path("y").asText();

        // 추출한 값 출력
        latLngList.add(firstX); // 위도
        latLngList.add(firstY); // 경도
        return latLngList;
    }
}