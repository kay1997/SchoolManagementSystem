package com.service.infrastructure;

import com.app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Building;
import com.factory.infrastructure.BuildingFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.infrastructure.BuildingRepository;
import com.repository.infrastructure.impl.BuildingRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class BuildingServiceTest {

    private BuildingRepository repository;
    private Building building;

    private Building getSavedBuilding() {
        Set<Building> savedBuildings = this.repository.getAll();
        return savedBuildings.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BuildingRepositoryImpl.getRepository();
        this.building = BuildingFactory.getBuilding("3", "Admin");
    }

    @Test
    public void a_create() {
        Building created = this.repository.create(this.building);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.building);
    }

    @Test
    public void b_read() {
        Building savedBuilding = getSavedBuilding();
        System.out.println("In read, building number = " + savedBuilding.getBuildingNumber());
        Building read = this.repository.read(savedBuilding.getBuildingNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedBuilding, read);
    }

    @Test
    public void e_delete() {
        Building savedBuilding = getSavedBuilding();
        this.repository.delete(savedBuilding.getBuildingNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newBuildingNumber = "New Test Building Contact Number";
        Building updated = new Building.Builder().copy(getSavedBuilding()).buildingNumber(newBuildingNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newBuildingNumber, updated.getBuildingNumber());
    }

    @Test
    public void d_getAll() {
        Set<Building> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
