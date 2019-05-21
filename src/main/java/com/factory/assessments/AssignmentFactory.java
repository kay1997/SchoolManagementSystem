package com.factory.assessments;

/*
 * Kaylen Abrahams
 * Student Number: 216054664
 * Group: 3G
 * */

import com.domain.assessments.Assignment;

public class AssignmentFactory {

    public static Assignment getAssignment(String assignmentNumber, String assignmentType) {
        return new Assignment.Builder().assignmentNumber(assignmentNumber)
                .assignmentType(assignmentType)
                .build();
    }
}

