package com.spring.utils.time;

import java.sql.Date;
import java.time.LocalDate;

public class Time {

    //자바의 LocalDateTime 데이터 타입을 DB에 insert할 때 필요
    public static Date insertTime(LocalDate ld) {
        return Date.valueOf(ld); // 2018-07-26 01:06:55.323
    }

    //DB의 TimeStamp 데이터 타입을 Java로 select하여 가져올 때 필요
    public static LocalDate getTime(Date d) {
        return d.toLocalDate(); // 2018-07-26T01:20:07.364
    }
}


