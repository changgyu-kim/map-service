package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.entity.User;
import com.spring.repository.SignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
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
class SignControllerTest {

    @Autowired
    private SignRepository signRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
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
    void 회원가입_성공() throws Exception {
        SignUpDto dto = new SignUpDto("loginId","12345asd","12345asd","이름","test@test.com","19950128","01012345678","남");

        mockMvc.perform(MockMvcRequestBuilders.post("/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
                ;
    }
    @Test
    void 로그인_성공() throws Exception {

        signRepository.insert(new User("loginId",passwordEncoder.encode("12345asd"),"이름","test@test.com","19950128","01012345678","남"));
        SignInDto dto = new SignInDto("loginId","12345asd");
        mockMvc.perform(MockMvcRequestBuilders.post("/sign-in")
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
}