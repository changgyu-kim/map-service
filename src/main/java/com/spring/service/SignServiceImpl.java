package com.spring.service;

import com.spring.controller.dto.SignInDto;
import com.spring.controller.dto.SignUpDto;
import com.spring.core.exception.ExceptionCode;
import com.spring.entity.User;
import com.spring.repository.SignRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.spring.core.exception.CustomException.validate;

@Service
@Transactional
public class SignServiceImpl implements SignService{

    private SignRepository signRepository;
    private PasswordEncoder passwordEncoder;

    public SignServiceImpl(SignRepository signRepository, PasswordEncoder passwordEncoder) {
        this.signRepository = signRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public int signUp(SignUpDto dto) {
        validate(dto.getPassword().equals(dto.getPasswordC()), ExceptionCode.NOT_EQUALS_PASSWORD);
        User user = new User(dto.getLoginId(), passwordEncoder.encode(dto.getPassword()), dto.getName(), dto.getEmail(), dto.getBirth(), dto.getPhone(), dto.getGender());
        return signRepository.insert(user);
    }

    @Override
    public User signIn(SignInDto dto) {
        User user = signRepository.findByLoginId(dto.getLoginId());
        validate(user != null, ExceptionCode.NOT_FOUND_USER);
        validate((passwordEncoder.matches(dto.getPassword(), user.getPassword())),ExceptionCode.NOT_EQUALS_PASSWORD);

        return user;
    }


}
