package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
import com.repository.admin.impl.SchoolRepositoryImpl;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class SchoolRepositoryImplTest {
    SchoolRepositoryImpl repository;
    School school;

    @Before
    public void setUp() throws Exception {

        repository = SchoolRepositoryImpl.getRepository();
        school = SchoolFactory.getSchool("R01", "Rocklands", "M/Plain", "0211234567");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(school);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(school);
        assertNotNull(repository.read(school.getSchoolCode()));
        System.out.println("Created\n" + repository.read(school.getSchoolCode()));
    }

    @Test
    public void read() {

        repository.create(school);

        School schools = repository.read(school.getSchoolCode());

        assertEquals(school, schools);
    }

    @Test
    public void update() {

        repository.create(school);

        School updatedSchool = SchoolFactory.getSchool("0123",  "Ridgeville", "M/Plain", "1234567890");

        repository.update(updatedSchool);

        Assert.assertNotEquals(school.getSchoolName(), updatedSchool.getSchoolName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}