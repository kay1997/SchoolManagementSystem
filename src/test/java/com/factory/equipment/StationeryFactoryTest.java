package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Stationery;

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
