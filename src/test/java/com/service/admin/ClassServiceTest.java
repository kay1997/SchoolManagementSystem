package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
import com.service.admin.impl.ClassServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.ClassRepository;
import com.repository.admin.impl.ClassRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ClassServiceTest {


    ClassServiceImpl service;
    Class cls;

    @Before
    public void setUp() throws Exception {
        service = ClassServiceImpl.getService();
        cls = ClassFactory.getClass("1", "A");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(cls);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(cls);
        assertNotNull(service.read("1"));
        System.out.println("Created\n" + service.read("1"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("1"));
        System.out.println("Read\n" + service.read("1"));
    }

    @Test
    public void update() {
        service.create(cls);
        System.out.println(service.read("1"));

        Class clsUpdated = ClassFactory.getClass("1", "B");
        service.update(clsUpdated);

        Class gen = service.read("1");
        Assert.assertNotEquals(cls.getClassGroup(), gen.getClassGroup());
        System.out.println("Updated\n" + service.read("1"));
    }

    @Test
    public void delete() {
        service.delete("1");
        assertNull(service.read(cls.getClassID()));
        System.out.println("Delete\n" + service.read(cls.getClassID()));
    }
}