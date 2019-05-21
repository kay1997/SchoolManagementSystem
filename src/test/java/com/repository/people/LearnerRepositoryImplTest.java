package com.repository.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Learner;
import com.factory.people.LearnerFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class LearnerRepositoryImplTest {

    @Autowired
    private LearnerRepository repository;
    private String learnerId=null;

    @Test
    public void CreateLearnerTest() throws IOException {
        Learner learner = LearnerFactory.getLearner("970826", "Kaylen", "Abrahams", "Strandloper", "0605220503",  22);
        Learner result = repository.create(learner);
        learnerId = result.getLearnerId();
        Assert.assertNotNull(learner);

    }
    @Test
    public void GetLearnerTest() throws IOException{

        Learner learner = repository.read(learnerId);
        Assert.assertNotNull(learner);
    }
}