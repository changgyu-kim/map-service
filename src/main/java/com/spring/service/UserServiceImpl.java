package com.spring.service;

import com.spring.controller.dto.UserUpdateDto;
import com.spring.entity.User;
import com.spring.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User update(UserUpdateDto dto, int id) {
        User foundedUser = userRepository.findById(id);
        foundedUser.update(passwordEncoder.encode(dto.getPassword()),dto.getName(), dto.getEmail(), dto.getPhone());
        userRepository.update(foundedUser);

        return foundedUser;
    }

    @Override
    public int delete(int id) {

        return userRepository.delete(id);
    }
}
