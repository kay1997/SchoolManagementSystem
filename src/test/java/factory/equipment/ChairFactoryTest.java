package factory.equipment;

import factory.equipment.ChairFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Chair;

public class ChairFactoryTest {

    @Test
    public void getChairNumber() {

        String id = "101";

        Chair chair = ChairFactory.getChair(id);
        System.out.println(chair);
        Assert.assertNotNull(chair.getChairNumber());
    }
}
