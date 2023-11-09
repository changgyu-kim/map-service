package com.spring.repository;

import com.spring.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class SignRepositoryTest {

    @Autowired
    SignRepository signRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void 유저정보_저장_성공() {
        int result = signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 유저정보_찾기_성공() {
        int result = signRepository.insert(new User("loginId",passwordEncoder.encode("12345asd"),"이름","test@test.com","19950128","01012345678","남"));
        User user = signRepository.findByLoginId("loginId");
        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getLoginId()).isEqualTo("loginId");
    }
}