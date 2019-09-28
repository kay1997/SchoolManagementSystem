package com.service.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Assignment;
import com.factory.assessments.AssignmentFactory;
import com.service.assessments.impl.AssignmentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class AssignmentServiceTest {

    AssignmentServiceImpl service;
    Assignment assignment;

    @Before
    public void setUp() throws Exception {
        service = AssignmentServiceImpl.getService();
        assignment = AssignmentFactory.getAssignment("12345", "Essay");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(assignment);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(assignment);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(assignment);
        System.out.println(service.read("12345"));

        Assignment assignmentUpdated = AssignmentFactory.getAssignment("12345", "Practical");
        service.update(assignmentUpdated);

        Assignment assign = service.read("12345");
        Assert.assertNotEquals(assignment.getAssignmentType(), assign.getAssignmentType());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(assignment.getAssignmentNumber()));
        System.out.println("Delete\n" + service.read(assignment.getAssignmentNumber()));
    }

}