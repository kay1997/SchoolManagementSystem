package com.repository.assessments;

import com.app.SchoolManagementSystemApplication;
import com.domain.assessments.Assignment;
import com.factory.assessments.AssignmentFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AssignmentRepositoryImplTest {
        @Autowired
        private AssignmentRepository repository;
        private String assignmentNo = null;

        @Test
        public void CreateAssignmentTest() throws IOException {
            Assignment assignment = AssignmentFactory.getAssignment("3", "Written");
            Assignment result = repository.create(assignment);
            assignmentNo = result.getAssignmentNumber();
            Assert.assertNotNull(assignment);
        }

        @Test
        public void GetAssignmentTest() throws IOException {

            Assignment assignment = repository.read(assignmentNo);
            Assert.assertNotNull(assignment);
        }
    }
