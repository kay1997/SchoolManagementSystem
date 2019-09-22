package com.repository.assessments;

import app.SchoolManagementSystemApplication;
import com.domain.assessments.Assignment;
import com.factory.assessments.AssignmentFactory;
import com.repository.assessments.impl.AssignmentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AssignmentRepositoryImplTest {
    AssignmentRepositoryImpl repository;
    Assignment assignment;

    @Before
    public void setUp() throws Exception {

        repository = AssignmentRepositoryImpl.getRepository();
        assignment = AssignmentFactory.getAssignment("01", "Practical");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(assignment);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(assignment);
        assertNotNull(repository.read(assignment.getAssignmentNumber()));
        System.out.println("Created\n" + repository.read(assignment.getAssignmentNumber()));
    }

    @Test
    public void read() {

        repository.create(assignment);

        Assignment assignments = repository.read(assignment.getAssignmentNumber());

        assertEquals(assignment, assignments);
    }

    @Test
    public void update() {

        repository.create(assignment);

        Assignment updatedAssignment = AssignmentFactory.getAssignment("01",  "Written");

        repository.update(updatedAssignment);

        Assert.assertNotEquals(assignment.getAssignmentType(), updatedAssignment.getAssignmentType());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}