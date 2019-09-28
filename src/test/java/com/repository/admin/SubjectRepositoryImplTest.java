package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
import com.repository.admin.impl.SubjectRepositoryImpl;
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
public class SubjectRepositoryImplTest {
    SubjectRepositoryImpl repository;
    Subject subject;

    @Before
    public void setUp() throws Exception {

        repository = SubjectRepositoryImpl.getRepository();
        subject = SubjectFactory.getSubject("002", "Maths");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(subject);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(subject);
        assertNotNull(repository.read(subject.getSubjectCode()));
        System.out.println("Created\n" + repository.read(subject.getSubjectCode()));
    }

    @Test
    public void read() {

        repository.create(subject);

        Subject subjects = repository.read(subject.getSubjectCode());

        assertEquals(subject, subjects);
    }

    @Test
    public void update() {

        repository.create(subject);

        Subject updatedSubject = SubjectFactory.getSubject("002",  "Afrikaans");

        repository.update(updatedSubject);

        Assert.assertNotEquals(subject.getSubjectName(), updatedSubject.getSubjectName());
    }
    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}