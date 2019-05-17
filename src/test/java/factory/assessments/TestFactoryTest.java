package factory.assessments;

import domain.assessments.Test;
import factory.assessments.TestFactory;
import org.junit.Assert;

public class TestFactoryTest {

    @org.junit.Test
    public void getTestPaperNumber() {

        String id = "1";
        String type = "Written";

        Test t = TestFactory.getTest(id, type);
        System.out.println(t);
        Assert.assertNotNull(t.getTestPaperNumber());
    }
}
