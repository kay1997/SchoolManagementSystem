package factory.admin;

import factory.admin.ClassFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.admin.Class;


public class ClassFactorytTest {

    @Test
    public void getClassGroup() {

        String group = "A";

        Class cls = ClassFactory.getClass(group);
        System.out.println(cls);
        Assert.assertNotNull(cls.getClassGroup());
    }
}
