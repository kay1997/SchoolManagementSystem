package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
import com.service.equipment.impl.DeskServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.DeskRepository;
import com.repository.equipment.impl.DeskRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class DeskServiceTest {

    DeskServiceImpl service;
    Desk desk;

    @Before
    public void setUp() throws Exception {
        service = DeskServiceImpl.getService();
        desk = DeskFactory.getDesk("01", "Glass");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(desk);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(desk);
        assertNotNull(service.read("01"));
        System.out.println("Created\n" + service.read("01"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("01"));
        System.out.println("Read\n" + service.read("01"));
    }

    @Test
    public void update() {
        service.create(desk);
        System.out.println(service.read("01"));

        Desk deskUpdated = DeskFactory.getDesk("01", "Wooden");
        service.update(deskUpdated);

        Desk des = service.read("01");
        Assert.assertNotEquals(desk.getDeskType(), des.getDeskType());
        System.out.println("Updated\n" + service.read("01"));
    }

    @Test
    public void delete() {
        service.delete(desk.getDeskNumber());
        assertNull(service.read(desk.getDeskNumber()));
        System.out.println("Delete\n" + service.read(desk.getDeskNumber()));
    }

}