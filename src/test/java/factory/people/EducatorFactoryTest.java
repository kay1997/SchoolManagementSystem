package factory.people;

import factory.people.EducatorFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Educator;

public class EducatorFactoryTest {

    @Test
    public void getEducatorIDNumber() {

        String id = "970826";
        String name = "Kaylen";
        String lname = "Abrahams";
        String dateOfBirth = "26/08/1997";
        String address = "Cape Town";
        String contactNumber = "0605220503";
        int age = 21;

        Educator e = EducatorFactory.getEducator(id, name, lname, dateOfBirth, address, contactNumber, age);
        System.out.println(e);
        Assert.assertNotNull(e.getEducatorIDNumber());
    }
}