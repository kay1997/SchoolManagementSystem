package com.service.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Lab;
import com.factory.infrastructure.LabFactory;
import com.service.infrastructure.impl.LabServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.infrastructure.LabRepository;
import com.repository.infrastructure.impl.LabRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class LabServiceTest {

    LabServiceImpl service;
    Lab lab;

    @Before
    public void setUp() throws Exception {
        service = LabServiceImpl.getService();
        lab = LabFactory.getLab("12345", "IT");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(lab);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(lab);
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
        service.create(lab);
        System.out.println(service.read("12345"));

        Lab labUpdated = LabFactory.getLab("12345", "Med");
        service.update(labUpdated);

        Lab b = service.read("12345");
        Assert.assertNotEquals(lab.getLabType(), b.getLabType());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(lab.getLabNumber()));
        System.out.println("Delete\n" + service.read(lab.getLabNumber()));
    }

}