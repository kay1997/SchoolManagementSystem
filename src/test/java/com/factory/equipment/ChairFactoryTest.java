package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Chair;

public class ChairFactoryTest {

    @Test
    public void getChairNumber() {

        String id = "101";
        String type = "Wooden";

        Chair chair = ChairFactory.getChair(id, type);
        System.out.println(chair);
        Assert.assertNotNull(chair.getChairNumber());
    }
}
