package repository.infrastructure;

import domain.infrastructure.Building;
import factory.infrastructure.BuildingFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.infrastructure.impl.BuildingRepositoryImpl;
import repository.infrastructure.BuildingRepository;

import java.util.Set;

public class BuildingRepositoryImplTest {

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
        Building building = new Building.Builder().copy(getSavedBuilding()).buildingNumber(newBuildingNumber).build();
        System.out.println("In update, about_to_updated = " + building);
        Building updated = this.repository.update(building);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newBuildingNumber, updated.getBuildingNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Building> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
