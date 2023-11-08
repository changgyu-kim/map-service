package com.spring.entity;

import com.spring.core.exception.ExceptionCode;
import com.spring.utils.conditions.RegexType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.spring.core.exception.CustomException.validate;
import static com.spring.utils.conditions.PreConditions.isNotBlank;
import static com.spring.utils.conditions.PreConditions.require;
import static com.spring.utils.conditions.RegexValidation.mathches;

@Getter
@NoArgsConstructor
public class User {

    private int id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String birth;
    private String phone;
    private String gender;
    private String img;
    private String role = "USER_ROLE";

    public User(String loginId, String password, String name, String email, String birth, String phone, String gender) {
        require(isNotBlank(loginId));
        require(isNotBlank(password));
        require(isNotBlank(name));
        require(isNotBlank(email));
        require(isNotBlank(birth));
        require(isNotBlank(phone));
        require(isNotBlank(gender));
        validate(mathches(loginId, RegexType.LOGINID), ExceptionCode.FAIL_LOGIN_REQUEST);
        validate(mathches(name, RegexType.NAME), ExceptionCode.FAIL_NAME_REQUEST);
        validate(mathches(email, RegexType.EMAIL), ExceptionCode.FAIL_EMAIL_REQUEST);
        validate(mathches(birth, RegexType.BIRTH), ExceptionCode.FAIL_BIRTH_REQUEST);
        validate(mathches(phone, RegexType.PHONE), ExceptionCode.FAIL_PHONE_REQUEST);
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
    }

    public void update(String password, String name, String email, String phone){
        require(isNotBlank(password));
        require(isNotBlank(name));
        require(isNotBlank(email));
        require(isNotBlank(phone));
        validate(mathches(name, RegexType.NAME), ExceptionCode.FAIL_NAME_REQUEST);
        validate(mathches(email, RegexType.EMAIL), ExceptionCode.FAIL_EMAIL_REQUEST);
        validate(mathches(phone, RegexType.PHONE), ExceptionCode.FAIL_PHONE_REQUEST);
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }



}
