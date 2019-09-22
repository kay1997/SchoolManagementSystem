package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Desk;

public class DeskFactoryTest {


    @Test
    public void getDeskNumber() {

        String id = "101";
        String type = "Steel";

        Desk desk = DeskFactory.getDesk(id, type);
        System.out.println(desk);
        Assert.assertNotNull(desk.getDeskNumber());
    }
}