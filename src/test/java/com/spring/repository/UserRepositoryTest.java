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
class UserRepositoryTest {

    @Autowired
    SignRepository signRepository;
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void 유저_수정_성공() {
        int result = signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        User user = signRepository.findByLoginId("loginId");
        user.update(passwordEncoder.encode("1234asdf"),"테스트","tttt@tttt.com","01087882572");
        int updateUser = userRepository.update(user);
        Assertions.assertThat(updateUser).isEqualTo(1);
    }
    @Test
    void 유저_삭제_성공() {
        int result = signRepository.insert(new User("loginId", "12345asd", "이름", "test@test.com", "19950128", "01012345678", "남"));
        User user = signRepository.findByLoginId("loginId");
        int deleteUser = userRepository.delete(user.getId());
        Assertions.assertThat(deleteUser).isEqualTo(1);
    }
}