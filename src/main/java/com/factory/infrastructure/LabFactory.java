package com.factory.infrastructure;

import com.domain.infrastructure.Lab;

public class LabFactory {

    public static Lab getLab(String labNumber, String labType) {
        return new Lab.Builder().labNumber(labNumber)
                .labType(labType)
                .build();
    }
}