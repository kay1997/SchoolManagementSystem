package factory.equipment;

import factory.equipment.DeskFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Desk;

public class DeskFactoryTest {


    @Test
    public void getDeskNumber() {

        String id = "101";

        Desk desk = DeskFactory.getDesk(id);
        System.out.println(desk);
        Assert.assertNotNull(desk.getDeskNumber());
    }
}