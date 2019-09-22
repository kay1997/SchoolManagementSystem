package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
import com.service.admin.impl.ResultServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.ResultRepository;
import com.repository.admin.impl.ResultRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ResultServiceTest {

    ResultServiceImpl service;
    Result result;

    @Before
    public void setUp() throws Exception {
        service = ResultServiceImpl.getService();
        result = ResultFactory.getResult("12345", "70");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(result);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(result);
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
        service.create(result);
        System.out.println(service.read("12345"));

        Result resultUpdated = ResultFactory.getResult("12345", "80");
        service.update(resultUpdated);

        Result comp = service.read("12345");
        Assert.assertNotEquals(result.getSubjectMark(), comp.getSubjectMark());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(result.getLearnerID()));
        System.out.println("Delete\n" + service.read(result.getLearnerID()));
    }

}