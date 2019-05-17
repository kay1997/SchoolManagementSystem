package factory.people;

import factory.people.LearnerFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Learner;

public class LearnerFactoryTest {

    @Test
    public void getLearnerFirstName() {

        String id = "050215";
        String name = "Kevin";
        String lname = "Abrahams";
        String address = "Cape Town";
        String telephone = "0605220503";
        int age = 14;

        Learner l = LearnerFactory.getLearner(id, name, lname, address, telephone, age);
        System.out.println(l);
        Assert.assertNotNull(l.getLearnerFirstName());
    }
}
