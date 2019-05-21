package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Projector;

public class ProjectorFactoryTest {


    @Test
    public void getProjectorCode() {

        String id = "123456788";
        String name = "Samsung";


        Projector projector = ProjectorFactory.getProjector(id, name);
        System.out.println(projector);
        Assert.assertNotNull(projector.getProjectorCode());
    }
}