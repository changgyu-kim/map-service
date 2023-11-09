package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.controller.dto.NoticeCreateDto;
import com.spring.controller.dto.NoticeUpdateDto;
import com.spring.entity.Notice;
import com.spring.entity.User;
import com.spring.repository.NoticeRepository;
import com.spring.repository.SignRepository;
import com.spring.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/dispatcherServlet.xml","file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class NoticeControllerTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SignRepository signRepository;
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    void testMock() {
        System.out.println("mockMvc = " + mockMvc);
    }
    @Test
    void 공지사항_생성_성공() throws Exception {
        signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        User user = signRepository.findByLoginId("loginId");
        NoticeCreateDto dto = new NoticeCreateDto("제목","내용","Y");

        mockMvc.perform(MockMvcRequestBuilders.post("/notice-create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto))
                        .sessionAttr("user",user))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
        ;
    }

    @Test
    void 공지사항_단건조회_성공() throws Exception {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        mockMvc.perform(MockMvcRequestBuilders.get("/notice/{id}",notice.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
                .andExpect(MockMvcResultMatchers.jsonPath("data.id").isNotEmpty())
        ;
    }
    @Test
    void 공지사항_수정_성공() throws Exception {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");
        NoticeUpdateDto dto = new NoticeUpdateDto("수정제목","수정내용","N");

        mockMvc.perform(MockMvcRequestBuilders.patch("/notice/{id}",notice.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
                .andExpect(MockMvcResultMatchers.jsonPath("data.id").isNotEmpty())
        ;
    }
    @Test
    void 공지사항_수정_삭제() throws Exception {
        noticeRepository.insert(new Notice("제목","내용","Y","작성자"));
        Notice notice = noticeRepository.getTestNotice("제목");

        mockMvc.perform(MockMvcRequestBuilders.delete("/notice/{id}",notice.getId()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
        ;
    }

}