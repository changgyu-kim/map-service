package com.spring.core.response;

import com.spring.core.exception.ExceptionCode;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

// 원하는 형식을 공통된 포맷을 만들어서 json형태로 보내주는 역할을 한다.
// Body = {"code":"S000","message":"success","data":null} 이렇게 보여지도록
@Builder // 객체를 생성할 때 빌더 패턴을 쉽게사용(빌더패턴을 자동으로 생성해줌)(Lombok)
// 빌더패턴은 생성자로만 객체를 생성했을때의 문제점들을 해결하기 위한 패턴이다
// 생성자로만 객체생성 시 문제점
    // 1. 생성자의 로직에 변경사항이 생길경우 파라미터가 계속 추가된다.(== 생성자의 오버로딩의 갯수가 계속 늘어나게 된다, 호출하는 클래스들이 생성자에 매개변수를 1,2,3,4 ... 개 필요할 수도 있기 때문)
// 문제점을 해결하기 위한 방법
    // 1. setter를 이용하여 나중에 추가된 값은 set()으로 설정할 수 있도록 하는 방법
    // 2. Builer을 이용하여 . 을 활용하여 연쇄적인 메서드를 작성하고 build() 메서드를 뒤에 작성하게 되면 객체가 생성된다.
@Data
public class ApiResult<T> { // 제네릭클래스를 사용하는이유는 변수의 데이터 타입과 관련이 있다. (변수에 어떤 객체가 들어올지 모르기 때문에 제네릭클래스 사용). 클래스 호출 시? 구체적인 타입이 결정되도록 함.
                            // 제네릭클래스를 안쓰고 변수가 Object 클래스를 반환타입으로 가질수도 있지만 이렇게하면 그 변수의 값을 가져와 사용할때마다 형 변환이나 타입체크를 해주어야한다.
    private String code;
    private String message;
    private T data;

    // 데이터가 나갈게 없을경우(스테틱 메서드)
    public static ApiResult<?> of(ExceptionCode exceptionCode){
        return ApiResult.of(exceptionCode, null);
    }

    // 데이터가 나갈게 있을경우 사용됨(스테틱 메서드)
    public static <T> ApiResult<T> of(ExceptionCode exceptionCode, T data) {
        // 빌더패턴은 생성자패턴의 한 종류이다. null이 들어와도 스킵하고 처리해줌. 유연하게 설계하고 대처할 수 있도록
        // 아래 자체가 빌더패턴으로 만들어지는 생성자라고 봐도된다.(build()를 하면 new 랑 똑같음)
                        // <T>는 builer() 메서드의 타입이다.
        return ApiResult.<T>builder() // 롬복 빌더가 현재클래스의 builder() 라는 스태틱 메서드를 구현해주어서 사용가능.(현재클래스의 생성된 객체를 리턴해줌 == new ApiResult(code, message, data))
                .code(exceptionCode.getCode())
                .message(exceptionCode.getMessage())
                .data(data)
                .build();
    }
}
