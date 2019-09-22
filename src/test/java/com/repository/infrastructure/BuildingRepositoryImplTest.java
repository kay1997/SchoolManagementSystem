package com.repository.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;

import com.repository.infrastructure.impl.BuildingRepositoryImpl;
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
public class BuildingRepositoryImplTest {
    BuildingRepositoryImpl repository;
    Building building;

    @Before
    public void setUp() throws Exception {

        repository = BuildingRepositoryImpl.getRepository();
        building = BuildingFactory.getBuilding("002", "Admin");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(building);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(building);
        assertNotNull(repository.read(building.getBuildingNumber()));
        System.out.println("Created\n" + repository.read(building.getBuildingNumber()));
    }

    @Test
    public void read() {

        repository.create(building);

        Building buildings = repository.read(building.getBuildingNumber());

        assertEquals(building, buildings);
    }

    @Test
    public void update() {

        repository.create(building);

        Building updatedBuilding = BuildingFactory.getBuilding("002",  "Library");

        repository.update(updatedBuilding);

        Assert.assertNotEquals(building.getBuildingName(), updatedBuilding.getBuildingName());
    }
    @Test
    public void delete() {
        repository.delete("002");
        assertNull(repository.read("002"));
        System.out.println("Deleted\n" + repository.read("002"));
    }

}