package factory.equipment;

import factory.equipment.ProjectorFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Projector;

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