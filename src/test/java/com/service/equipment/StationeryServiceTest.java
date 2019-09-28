package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
import com.service.equipment.impl.StationeryServiceImpl;
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
public class StationeryServiceTest {

    StationeryServiceImpl service;
    Stationery stationery;

    @Before
    public void setUp() throws Exception {
        service = StationeryServiceImpl.getService();
        stationery = StationeryFactory.getStationery("12345", "Pen");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(stationery);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(stationery);
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
        service.create(stationery);
        System.out.println(service.read("12345"));

        Stationery stationeryUpdated = StationeryFactory.getStationery("12345", "Pencil");
        service.update(stationeryUpdated);

        Stationery comp = service.read("12345");
        Assert.assertNotEquals(stationery.getStationeryType(), comp.getStationeryType());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(stationery.getStationeryCode()));
        System.out.println("Delete\n" + service.read(stationery.getStationeryCode()));
    }

}