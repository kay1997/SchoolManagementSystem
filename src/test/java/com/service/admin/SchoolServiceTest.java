package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
import com.service.admin.impl.SchoolServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Set;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.SchoolRepository;
import com.repository.admin.impl.SchoolRepositoryImpl;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SchoolServiceTest {

    SchoolServiceImpl service;
    School school;

    @Before
    public void setUp() throws Exception {
        service = SchoolServiceImpl.getService();
        school = SchoolFactory.getSchool("12345", "Westridge", "M/Plain", "0211234526");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(school);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(school);
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
        service.create(school);
        System.out.println(service.read("12345"));

        School schoolUpdated = SchoolFactory.getSchool("12345", "Rocklands", "M/Plain", "0211234526");
        service.update(schoolUpdated);

        School emp = service.read("12345");
        Assert.assertNotEquals(school.getSchoolName(), emp.getSchoolName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(school.getSchoolCode()));
        System.out.println("Delete\n" + service.read(school.getSchoolCode()));
    }

}
