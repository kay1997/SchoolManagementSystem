package factory.people;

import factory.people.SecurityFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Security;

public class SecurityFactoryTest {

    @Test
    public void getSecurityIDNumber() {

        String id = "970826";
        String name = "Kaylen";
        String lname = "Abrahams";
        String dateOfBirth = "26/08/1997";
        String address = "Cape Town";
        String contactNumber = "0605220503";
        int age = 21;

        Security security = SecurityFactory.getSecurity(id, name, lname, dateOfBirth, address, contactNumber, age);
        System.out.println(security);
        Assert.assertNotNull(security.getSecurityIDNumber());
    }
}
