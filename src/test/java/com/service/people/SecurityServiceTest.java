package com.service.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Security;
import com.factory.people.SecurityFactory;
import com.service.people.impl.SecurityServiceImpl;
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
public class SecurityServiceTest {

    SecurityServiceImpl service;
    Security security;

    @Before
    public void setUp() throws Exception {
        service = SecurityServiceImpl.getService();
        security = SecurityFactory.getSecurity("12345", "Kaylen", "Abrahams", "26", "CPT", "12345", 22);
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

        Security securityUpdated = SecurityFactory.getSecurity("12345", "Kevin", "Abrahams", "26", "CPT", "12345", 22);
        service.update(securityUpdated);

        Security emp = service.read("12345");
        Assert.assertNotEquals(security.getSecurityFirstName(), emp.getSecurityFirstName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(security.getSecurityIDNumber()));
        System.out.println("Delete\n" + service.read(security.getSecurityIDNumber()));
    }

}
