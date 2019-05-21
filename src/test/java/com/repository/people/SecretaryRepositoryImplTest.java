package com.repository.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
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

public class SecretaryRepositoryImplTest {
    @Autowired
    private SecretaryRepository repository;
    private String secretaryId = null;

    @Test
    public void CreateSecretaryTest() throws IOException {
        Secretary secretary = SecretaryFactory.getSecretary("970826", "Kaylen", "Abrahams", "260897", "Strandloper", "0605220503", 22);
        Secretary result = repository.create(secretary);
        secretaryId = result.getSecretaryIDNumber();
        Assert.assertNotNull(secretary);
    }

    @Test
    public void GetSecretaryTest() throws IOException {

        Secretary secretary = repository.read(secretaryId);
        Assert.assertNotNull(secretary);
    }
}