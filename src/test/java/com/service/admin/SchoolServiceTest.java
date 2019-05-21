package com.service.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SchoolServiceTest {


    private SchoolRepository repository;
    private School school;

    private School getSavedSchool() {
        Set<School> savedSchools = this.repository.getAll();
        return savedSchools.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SchoolRepositoryImpl.getRepository();
        this.school = SchoolFactory.getSchool("012", "Rocklands High", "Cape Town", "0213921234");
    }

    @Test
    public void a_create() {
        School created = this.repository.create(this.school);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.school);
    }

    @Test
    public void b_read() {
        School savedSchool = getSavedSchool();
        System.out.println("In read, school code = " + savedSchool.getSchoolCode());
        School read = this.repository.read(savedSchool.getSchoolCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSchool, read);
    }

    @Test
    public void e_delete() {
        School savedSchool = getSavedSchool();
        this.repository.delete(savedSchool.getSchoolCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newSchoolNumber = "New Test School Contact Number";
        School updated = new School.Builder().copy(getSavedSchool()).schoolContactNumber(newSchoolNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSchoolNumber, updated.getSchoolContactNumber());
    }

    @Test
    public void d_getAll() {
        Set<School> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
