package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.controller.dto.UserUpdateDto;
import com.spring.entity.User;
import com.spring.repository.SignRepository;
import com.spring.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringJUnitWebConfig(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/dispatcherServlet.xml","file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class UserControllerTest {
    @Autowired
    private SignRepository signRepository;
    @Autowired
    private UserRepository userRepository;
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
    void 유저_수정_성공() throws Exception {
        signRepository.insert(new User("loginId",passwordEncoder.encode("12345asd"),"이름","test@test.com","19950128","01012345678","남"));
        User user = signRepository.findByLoginId("loginId");
        UserUpdateDto dto = new UserUpdateDto("1234asdf","테스트","tttt@tttt.com","01087882572");
        mockMvc.perform(MockMvcRequestBuilders.patch("/user/{id}",user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
        ;
    }
    @Test
    void 유저_삭제_성공() throws Exception {
        signRepository.insert(new User("loginId",passwordEncoder.encode("12345asd"),"이름","test@test.com","19950128","01012345678","남"));
        User user = signRepository.findByLoginId("loginId");

        mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}",user.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("S000"))
        ;
    }
}