package com.service.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;
import com.service.infrastructure.impl.BuildingServiceImpl;
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
public class BuildingServiceTest {

    BuildingServiceImpl service;
    Building building;

    @Before
    public void setUp() throws Exception {
        service = BuildingServiceImpl.getService();
        building = BuildingFactory.getBuilding("12345", "Commerce");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(building);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(building);
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
        service.create(building);
        System.out.println(service.read("12345"));

        Building buildingUpdated = BuildingFactory.getBuilding("12345", "IT");
        service.update(buildingUpdated);

        Building b = service.read("12345");
        Assert.assertNotEquals(building.getBuildingName(), b.getBuildingName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(building.getBuildingNumber()));
        System.out.println("Delete\n" + service.read(building.getBuildingNumber()));
    }

}