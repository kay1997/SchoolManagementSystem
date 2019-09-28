package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Learner;
import com.factory.people.LearnerFactory;
import com.repository.people.impl.LearnerRepositoryImpl;
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
public class LearnerRepositoryImplTest {

    LearnerRepositoryImpl repository;
    Learner learner;

    @Before
    public void setUp() throws Exception {

        repository = LearnerRepositoryImpl.getRepository();
        learner = LearnerFactory.getLearner("123", "K", "Adams", "Cape Town",  "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(learner);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(learner);
        assertNotNull(repository.read(learner.getLearnerId()));
        System.out.println("Created\n" + repository.read(learner.getLearnerId()));
    }

    @Test
    public void read() {

        repository.create(learner);

        Learner learners = repository.read(learner.getLearnerId());

        assertEquals(learner, learners);
    }

    @Test
    public void update() {

        repository.create(learner);

        Learner updatedLearner = LearnerFactory.getLearner("123", "K", "Abrahams", "Cape Town",  "0213920626", 22);

        repository.update(updatedLearner);

        Assert.assertNotEquals(learner.getLearnerLastName(), updatedLearner.getLearnerLastName());
    }
    @Test
    public void delete() {
        repository.delete("123");
        assertNull(repository.read("123"));
        System.out.println("Deleted\n" + repository.read("123"));
    }

}