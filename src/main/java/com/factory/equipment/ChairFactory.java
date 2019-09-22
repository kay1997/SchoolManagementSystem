package com.factory.equipment;


import com.domain.equipment.Chair;

public class ChairFactory {

    public static Chair getChair(String chairNumber, String chairType) {
        return new Chair.Builder().chairNumber(chairNumber).chairType(chairType).build();
    }
}

