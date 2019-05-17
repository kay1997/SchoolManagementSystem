package factory.equipment;

import factory.equipment.StationeryFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Stationery;

public class StationeryFactoryTest {

    @Test
    public void getStationeryCode() {

        String id = "103";
        String type = "Pencil";

        Stationery stationery = StationeryFactory.getStationery(id, type);
        System.out.println(stationery);
        Assert.assertNotNull(stationery.getStationeryCode());
    }
}
