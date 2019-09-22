package com.service.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Principle;
import com.factory.people.PrincipleFactory;
import com.service.people.impl.PrincipleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.PrincipleRepository;
import com.repository.people.impl.PrincipleRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class PrincipleServiceTest {

    PrincipleServiceImpl service;
    Principle principle;

    @Before
    public void setUp() throws Exception {
        service = PrincipleServiceImpl.getService();
        principle = PrincipleFactory.getPrinciple("12345", "Kaylen", "Abrahams", "26", "CPT", "12345", 22);
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(principle);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(principle);
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
        service.create(principle);
        System.out.println(service.read("12345"));

        Principle principleUpdated = PrincipleFactory.getPrinciple("12345", "Kevin", "Abrahams", "26", "CPT", "12345", 22);
        service.update(principleUpdated);

        Principle emp = service.read("12345");
        Assert.assertNotEquals(principle.getPrincipleFirstName(), emp.getPrincipleFirstName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(principle.getPrincipleIDNumber()));
        System.out.println("Delete\n" + service.read(principle.getPrincipleIDNumber()));
    }

}