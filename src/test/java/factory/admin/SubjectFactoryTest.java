package factory.admin;

import factory.admin.SubjectFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.admin.Subject;

public class SubjectFactoryTest {
    @Test
    public void getSubjectName() {

        String name = "Mathematics";
        String code = "MATH003";

        Subject subject = SubjectFactory.getSubject(name, code);
        System.out.println(subject);
        Assert.assertNotNull(subject.getSubjectName());
    }

}
