package com.spring.utils.conditions;

public class RegexValidation {

    // 영문자로 이루어진 로그인아이디, 4글자이상, 12글자 이하
    private static final String LOGINID_PATTERN = "^[a-zA-Z]{4,12}$"; // static final 은 변수이름 대문자로


    //문자+숫자, 8자이상, 특수문자는 선택
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d).{8,15}$";

    //이름 한글만 가능
    private static final String NAME_PATTERN = "^[가-힣]{2,4}$";

    //이메일형식 ..@...com
    private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[_a-z0-9-]+)@(?:\\w+\\.)+\\w+$";

    // 생년월일 (ex. 19950128)
    private static final String BIRTH_PATTERN = "^(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";

    // 핸드폰번호 (ex. 01012345678)
    private static final String PHONE_PATTERN = "^01[016789]\\d{8}$";


    public static Boolean mathches(String s, RegexType type){
        switch (type){
            case LOGINID :
                if(s.matches(LOGINID_PATTERN)){
                    return true;
                }
                break;
            case PASSWORD :
                if(s.matches(PASSWORD_PATTERN)){
                    return true;
                }
                break;
            case NAME :
                if(s.matches(NAME_PATTERN)){
                    return true;
                }
                break;
            case EMAIL :
                if(s.matches(EMAIL_PATTERN)){
                    return true;
                }
                break;
            case BIRTH :
                if(s.matches(BIRTH_PATTERN)){
                    return true;
                }
                break;
            case PHONE :
                if(s.matches(PHONE_PATTERN)){
                    return true;
                }
                break;
            default : return false;
        }
        return false;
    }
    
}
