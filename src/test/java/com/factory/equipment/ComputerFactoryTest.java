package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Computer;

public class ComputerFactoryTest {

    @Test
    public void getComputerNumber() {

        String id = "123456789";
        String name = "Dell";


        Computer comp = ComputerFactory.getComputer(id, name);
        System.out.println(comp);
        Assert.assertNotNull(comp.getComputerNumber());
    }
}
