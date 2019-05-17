package factory.people;

import factory.people.SecretaryFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Secretary;

public class SecretaryFactoryTest {

    @Test
    public void getSecretaryIDNumber() {

        String id = "901101";
        String name = "Amy";
        String lname = "Adams";
        String dateOfBirth = "01/11/1990";
        String address = "Cape Town";
        String contactNumber = "0612345678";
        int age = 29;

        Secretary secretary = SecretaryFactory.getSecretary(id, name, lname, dateOfBirth, address, contactNumber, age);
        System.out.println(secretary);
        Assert.assertNotNull(secretary.getSecretaryIDNumber());
    }
}
