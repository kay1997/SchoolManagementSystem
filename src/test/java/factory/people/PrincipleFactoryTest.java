package factory.people;

import factory.people.PrincipleFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Principle;

public class PrincipleFactoryTest {

    @Test
    public void getPrincipleIDNumber() {

        String id = "770826";
        String name = "David";
        String lname = "Goliath";
        String dateOfBirth = "26/08/1977";
        String address = "Cape Town";
        String contactNumber = "0213920111";
        int age = 42;

        Principle p = PrincipleFactory.getPrinciple(id, name, lname, dateOfBirth, address, contactNumber, age);
        System.out.println(p);
        Assert.assertNotNull(p.getPrincipleIDNumber());
    }
}
