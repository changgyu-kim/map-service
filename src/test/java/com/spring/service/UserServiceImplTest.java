package com.spring.service;

import com.spring.controller.dto.UserUpdateDto;
import com.spring.entity.User;
import com.spring.repository.SignRepository;
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
class UserServiceImplTest {
    @Autowired
    SignRepository signRepository;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void 유저_수정_성공() {
        signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        User user = signRepository.findByLoginId("loginId");
        UserUpdateDto dto = new UserUpdateDto("1234asdf","테스트","tttt@tttt.com","01087882572");
        User updateUser = userService.update(dto,user.getId());
        Assertions.assertThat(updateUser.getName()).isEqualTo("테스트");
    }
    @Test
    void 유저_삭제_성공() {
        signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        User user = signRepository.findByLoginId("loginId");
        int result = userService.delete(user.getId());
        Assertions.assertThat(result).isEqualTo(1);
    }
}