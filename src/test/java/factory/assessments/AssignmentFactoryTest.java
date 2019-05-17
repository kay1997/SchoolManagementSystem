package factory.assessments;


/*
 * Kaylen Abrahams
 * Student Number: 216054664
 * Group: 3G
 * */

import factory.assessments.AssignmentFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.assessments.Assignment;

public class AssignmentFactoryTest {

    @Test
    public void getAssignmentNumber() {

        String id = "1";
        String type = "Essay";

        Assignment assignment = AssignmentFactory.getAssignment(id, type);
        System.out.println(assignment);
        Assert.assertNotNull(assignment.getAssignmentNumber());
    }
}
