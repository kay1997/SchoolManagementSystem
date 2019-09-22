package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
import com.service.equipment.impl.ComputerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.ComputerRepository;
import com.repository.equipment.impl.ComputerRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ComputerServiceTest {

    ComputerServiceImpl service;
    Computer computer;

    @Before
    public void setUp() throws Exception {
        service = ComputerServiceImpl.getService();
        computer = ComputerFactory.getComputer("12345", "Dell");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(computer);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(computer);
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
        service.create(computer);
        System.out.println(service.read("12345"));

        Computer computerUpdated = ComputerFactory.getComputer("12345", "HP");
        service.update(computerUpdated);

        Computer comp = service.read("12345");
        Assert.assertNotEquals(computer.getComputerName(), comp.getComputerName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(computer.getComputerNumber()));
        System.out.println("Delete\n" + service.read(computer.getComputerNumber()));
    }

}