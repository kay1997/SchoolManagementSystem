package factory.infrastructure;

import factory.infrastructure.LabFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.infrastructure.Lab;

public class LabFactoryTest {

    @Test
    public void getExamPaperNumber() {

        String number = "2";
        String type = "Computer Lab";

        Lab lab = LabFactory.getLab(number, type);
        System.out.println(lab);
        Assert.assertNotNull(lab.getLabNumber());
    }
}
