package com.service.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
import com.service.people.impl.EducatorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.EducatorRepository;
import com.repository.people.impl.EducatorRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class EducatorServiceTest {

    EducatorServiceImpl service;
    Educator educator;

    @Before
    public void setUp() throws Exception {
        service = EducatorServiceImpl.getService();
        educator = EducatorFactory.getEducator("12345", "Kaylen", "Abrahams", "26", "CPT", "12345", 22);
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(educator);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(educator);
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
        service.create(educator);
        System.out.println(service.read("12345"));

        Educator educatorUpdated = EducatorFactory.getEducator("12345", "Kevin", "Abrahams", "26", "CPT", "12345", 22);
        service.update(educatorUpdated);

        Educator emp = service.read("12345");
        Assert.assertNotEquals(educator.getEducatorFirstName(), emp.getEducatorFirstName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(educator.getEducatorIDNumber()));
        System.out.println("Delete\n" + service.read(educator.getEducatorIDNumber()));
    }

}