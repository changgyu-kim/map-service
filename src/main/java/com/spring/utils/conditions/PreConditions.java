package com.spring.utils.conditions;

public class PreConditions {

    public static void require(boolean expression){
        if(!expression){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNotBlank(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }
}
