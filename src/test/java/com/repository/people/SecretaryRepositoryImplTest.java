package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
import com.repository.people.impl.SecretaryRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)

public class SecretaryRepositoryImplTest {
    SecretaryRepositoryImpl repository;
    Secretary secretary;

    @Before
    public void setUp() throws Exception {

        repository = SecretaryRepositoryImpl.getRepository();
        secretary = SecretaryFactory.getSecretary("123", "K", "Adams", "97", "Cape Town", "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(secretary);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(secretary);
        assertNotNull(repository.read(secretary.getSecretaryIDNumber()));
        System.out.println("Created\n" + repository.read(secretary.getSecretaryIDNumber()));
    }

    @Test
    public void read() {

        repository.create(secretary);

        Secretary secretaries = repository.read(secretary.getSecretaryIDNumber());

        assertEquals(secretary, secretaries);
    }

    @Test
    public void update() {

        repository.create(secretary);

        Secretary updatedSecretary = SecretaryFactory.getSecretary("123", "Aiden", "Adams", "97", "Cape Town", "0213920626", 22);

        repository.update(updatedSecretary);

        Assert.assertNotEquals(secretary.getSecretaryFirstName(), updatedSecretary.getSecretaryFirstName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}