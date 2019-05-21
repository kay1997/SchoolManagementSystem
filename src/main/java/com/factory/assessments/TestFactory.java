package com.factory.assessments;

import com.domain.assessments.Test;

public class TestFactory {

    public static Test getTest(String testPaperNumber, String testType) {
    return new Test.Builder().testPaperNumber(testPaperNumber)
            .testType(testType)
            .build();
}
}
