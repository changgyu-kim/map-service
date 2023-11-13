package com.spring.utils.crawling;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
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
    void 지오코딩테스트() {
        String location = "경기도 성남시 분당구 삼평동";
        Float[] coords = geoCoding(location);
        System.out.println(location);
    }

    public static Float[] geoCoding(String location) {
        if (location == null){
            return null;
        }
        Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(location).setLanguage("ko").getGeocoderRequest();
        GeocodeResponse geocoderResponse;

        try {
            geocoderResponse = geocoder.geocode(geocoderRequest);
            System.out.println("geocoderRequest = " + geocoderResponse.getResults());
            System.out.println("geocoderRequest = " + geocoderResponse.getStatus());
            if (geocoderResponse.getStatus() == GeocoderStatus.OK & !geocoderResponse.getResults().isEmpty()) {
                GeocoderResult geocoderResult=geocoderResponse.getResults().iterator().next();
                LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
                Float[] coords = new Float[2];
                coords[0] = latitudeLongitude.getLat().floatValue();
                coords[1] = latitudeLongitude.getLng().floatValue();
                return coords;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            }
        return null;
    }
    static List<Store> storeList = new ArrayList<>();
    @Test
    void 데이터크롤링_성공() {
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
    private static void crawlPage(ChromeDriver driver) {

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

    private static void printElementsInSequence(Elements... elementsArray) {
        int maxElements = 0;
        for (Elements elements : elementsArray) {
            maxElements = Math.max(maxElements, elements.size());
        }

        for (int i = 1; i < maxElements; i++) {
            List htmlList = new ArrayList();

            for (Elements elements : elementsArray) {
                if (i < elements.size()) {
                    Element currentElement = elements.get(i);
                    //System.out.println(currentElement.text());
                    htmlList.add(currentElement.text());
                }
            }

            Store store = new Store(Integer.parseInt((String) htmlList.get(0)),(String)htmlList.get(1),(String)htmlList.get(2),(String)htmlList.get(3),(String)htmlList.get(4),(String)htmlList.get(5),(String)htmlList.get(6),"123.123","123.556");
            System.out.println(store.getId());
            System.out.println(store.getName());
            System.out.println(store.getAddress());
            storeList.add(store);
        }
    }
}