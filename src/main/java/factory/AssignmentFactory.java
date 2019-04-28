package factory;

/*
 * Kaylen Abrahams
 * Student Number: 216054664
 * Group: 3G
 * */

import domain.Assignment;

public class AssignmentFactory {

    public static Assignment getAssignment(String assignmentNumber, String assignmentType) {
        return new Assignment.Builder().assignmentNumber(assignmentNumber)
                .assignmentType(assignmentType)
                .build();
    }
}

