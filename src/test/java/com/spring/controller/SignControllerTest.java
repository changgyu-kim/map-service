package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.repository.SignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class SignControllerTest {

    @Autowired
    private SignRepository signRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private WebApplicationContext webApplicationContext; // WebApplicationContext 주입
    private MockMvc mockMvc; // MockMvc 필드

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // MockMvc를 설정하는 메서드
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

/*    @Test
    void 회원가입_성공() {
        SignUpDto dto = new SignUpDto("loginId",passwordEncoder.encode("12345asd"),"12345asd","이름","test@test.com","19950128","01012345678","남");

        mockMvc.perform(MockMvcRequestBuilders.post("/sing-up")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(dto)
                .andDo(MockMvcResultHandlers.print())
                );
    }*/
}