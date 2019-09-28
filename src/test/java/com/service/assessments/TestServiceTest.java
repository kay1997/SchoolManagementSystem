package com.service.assessments;

import app.SchoolManagementSystemApplication;
import com.factory.assessments.TestFactory;
import com.service.assessments.impl.TestServiceImpl;
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
public class TestServiceTest {

    TestServiceImpl service;
    com.domain.assessments.Test test;

    @Before
    public void setUp() throws Exception {
        service = TestServiceImpl.getService();
        test = TestFactory.getTest("12345", "Written");
    }

    @org.junit.Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @org.junit.Test
    public void getAll() {
        service.create(test);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @org.junit.Test
    public void create() {
        service.create(test);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @org.junit.Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @org.junit.Test
    public void update() {
        service.create(test);
        System.out.println(service.read("12345"));

        com.domain.assessments.Test testUpdated = TestFactory.getTest("12345", "Online");
        service.update(testUpdated);

        com.domain.assessments.Test comp = service.read("12345");
        Assert.assertNotEquals(test.getTestType(), comp.getTestType());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(test.getTestPaperNumber()));
        System.out.println("Delete\n" + service.read(test.getTestPaperNumber()));
    }

}