package com.service.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
import com.service.people.impl.SecretaryServiceImpl;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SecretaryServiceTest {
    SecretaryServiceImpl service;
    Secretary security;

    @Before
    public void setUp() throws Exception {
        service = SecretaryServiceImpl.getService();
        security = SecretaryFactory.getSecretary("12345", "Kaylen", "Abrahams", "26", "CPT", "12345", 22);
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(security);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(security);
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
        service.create(security);
        System.out.println(service.read("12345"));

        Secretary securityUpdated = SecretaryFactory.getSecretary("12345", "Kevin", "Abrahams", "26", "CPT", "12345", 22);
        service.update(securityUpdated);

        Secretary emp = service.read("12345");
        Assert.assertNotEquals(security.getSecretaryFirstName(), emp.getSecretaryFirstName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(security.getSecretaryIDNumber()));
        System.out.println("Delete\n" + service.read(security.getSecretaryIDNumber()));
    }

}