package com.spring.entity;

import com.spring.core.exception.CustomException;
import com.spring.core.exception.ExceptionCode;
import com.spring.utils.conditions.RegexType;
import com.spring.utils.conditions.RegexValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.spring.core.exception.CustomException.*;
import static com.spring.utils.conditions.PreConditions.*;
import static com.spring.utils.conditions.RegexValidation.mathches;

@Getter
@NoArgsConstructor
public class User {

    private int id;
    private String login_id;
    private String password;
    private String name;
    private String email;
    private String birth;
    private String phone;
    private String gender;
    private String img;
    private String role = "USER_ROLE";

    public User(String login_id, String password, String name, String email, String birth, String phone, String gender, String img) {
        require(isNotBlank(login_id));
        require(isNotBlank(password));
        require(isNotBlank(name));
        require(isNotBlank(email));
        require(isNotBlank(birth));
        require(isNotBlank(phone));
        require(isNotBlank(gender));
        validate(mathches(login_id, RegexType.LOGINID), ExceptionCode.FAIL_LOGIN_REQUEST);
        validate(mathches(password, RegexType.PASSWORD), ExceptionCode.FAIL_LOGIN_REQUEST);
        validate(mathches(name, RegexType.NAME), ExceptionCode.FAIL_NAME_REQUEST);
        validate(mathches(email, RegexType.EMAIL), ExceptionCode.FAIL_EMAIL_REQUEST);
        validate(mathches(birth, RegexType.BIRTH), ExceptionCode.FAIL_BIRTH_REQUEST);
        validate(mathches(phone, RegexType.PHONE), ExceptionCode.FAIL_PHONE_REQUEST);
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
        this.img = img;
    }



}
