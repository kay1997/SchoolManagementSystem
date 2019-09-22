package com.service.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
import com.service.admin.impl.SubjectServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.SubjectRepository;
import com.repository.admin.impl.SubjectRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SubjectServiceTest {

    SubjectServiceImpl service;
    Subject subject;

    @Before
    public void setUp() throws Exception {
        service = SubjectServiceImpl.getService();
        subject = SubjectFactory.getSubject("12345", "IT");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(subject);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(subject);
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
        service.create(subject);
        System.out.println(service.read("12345"));

        Subject subjectUpdated = SubjectFactory.getSubject("12345", "Maths");
        service.update(subjectUpdated);

        Subject comp = service.read("12345");
        Assert.assertNotEquals(subject.getSubjectName(), comp.getSubjectName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(subject.getSubjectCode()));
        System.out.println("Delete\n" + service.read(subject.getSubjectCode()));
    }

}