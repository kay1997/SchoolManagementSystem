package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
import com.repository.admin.impl.ClassRepositoryImpl;
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
public class ClassRepositoryImplTest {
    ClassRepositoryImpl repository;
    Class cls;

    @Before
    public void setUp() throws Exception {

        repository = ClassRepositoryImpl.getRepository();
        cls= ClassFactory.getClass("1", "A");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(cls);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(cls);
        assertNotNull(repository.read(cls.getClassID()));
        System.out.println("Created\n" + repository.read(cls.getClassID()));
    }

    @Test
    public void read() {

        repository.create(cls);

        Class clses = repository.read(cls.getClassID());

        assertEquals(cls, clses);
    }

    @Test
    public void update() {

       repository.create(cls);

        Class updatedClass = ClassFactory.getClass("1", "B");

        repository.update(updatedClass);

        Assert.assertNotEquals(cls.getClassGroup(), updatedClass.getClassGroup());
    }

    @Test
    public void delete() {
        repository.delete(cls.getClassID());
        assertNull(repository.read(cls.getClassID()));
        System.out.println("Deleted\n" + repository.read(cls.getClassID()));
    }

}