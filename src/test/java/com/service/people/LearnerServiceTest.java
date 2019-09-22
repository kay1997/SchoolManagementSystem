package com.service.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Learner;
import com.factory.people.LearnerFactory;
import com.service.people.impl.LearnerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.LearnerRepository;
import com.repository.people.impl.LearnerRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class LearnerServiceTest {


    LearnerServiceImpl service;
    Learner learner;

    @Before
    public void setUp() throws Exception {
        service = LearnerServiceImpl.getService();
        learner = LearnerFactory.getLearner("12345", "Kaylen", "Abrahams", "CPT", "12345", 22);
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(learner);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(learner);
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
        service.create(learner);
        System.out.println(service.read("12345"));

        Learner learnerUpdated = LearnerFactory.getLearner("12345", "Kevin", "Abrahams", "CPT", "12345", 22);
        service.update(learnerUpdated);

        Learner emp = service.read("12345");
        Assert.assertNotEquals(learner.getLearnerFirstName(), emp.getLearnerFirstName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(learner.getLearnerId()));
        System.out.println("Delete\n" + service.read(learner.getLearnerId()));
    }

}