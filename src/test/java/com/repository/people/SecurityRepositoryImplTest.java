package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Security;
import com.factory.people.SecurityFactory;
import com.repository.people.impl.SecurityRepositoryImpl;
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
public class SecurityRepositoryImplTest {

    SecurityRepositoryImpl repository;
    Security security;

    @Before
    public void setUp() throws Exception {

        repository = SecurityRepositoryImpl.getRepository();
        security = SecurityFactory.getSecurity("123", "K", "Adams", "97", "Cape Town", "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(security);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(security);
        assertNotNull(repository.read(security.getSecurityIDNumber()));
        System.out.println("Created\n" + repository.read(security.getSecurityIDNumber()));
    }

    @Test
    public void read() {

        repository.create(security);

        Security securities = repository.read(security.getSecurityIDNumber());

        assertEquals(security, securities);
    }

    @Test
    public void update() {

        repository.create(security);

        Security updatedSecurity = SecurityFactory.getSecurity("123", "John", "Adams", "97", "Cape Town", "0213920626", 22);

        repository.update(updatedSecurity);

        Assert.assertNotEquals(security.getSecurityFirstName(), updatedSecurity.getSecurityFirstName());
    }
    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}
