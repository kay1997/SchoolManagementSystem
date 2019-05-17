package factory.infrastructure;

import factory.infrastructure.BuildingFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.infrastructure.Building;

public class BuldingFactoryTest {

    @Test
    public void getBuildingName() {

        String id = "1";
        String name = "Administration";

        Building building = BuildingFactory.getBuilding(id, name);
        System.out.println(building);
        Assert.assertNotNull(building.getBuildingName());
    }
}
