package com.repository.assessments;

import app.SchoolManagementSystemApplication;
import com.factory.assessments.TestFactory;
import com.repository.assessments.impl.TestRepositoryImpl;
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
public class TestRepositoryImplTest {
    TestRepositoryImpl repository;
    com.domain.assessments.Test test;

    @Before
    public void setUp() throws Exception {

        repository = TestRepositoryImpl.getRepository();
        test = TestFactory.getTest("002", "Online");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(test);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(test);
        assertNotNull(repository.read(test.getTestPaperNumber()));
        System.out.println("Created\n" + repository.read(test.getTestPaperNumber()));
    }

    @Test
    public void read() {

        repository.create(test);

        com.domain.assessments.Test tests = repository.read(test.getTestPaperNumber());

        assertEquals(test, tests);
    }

    @Test
    public void update() {

        repository.create(test);

        com.domain.assessments.Test updatedGrade = TestFactory.getTest("002",  "Written");

        repository.update(updatedGrade);

        Assert.assertNotEquals(test.getTestType(), updatedGrade.getTestType());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}