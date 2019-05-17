package factory.people;

import factory.people.CaretakerFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.people.Caretaker;

public class CaretakerFactoryTest {

    @Test
    public void getCaretakerIDNumber() {

        String id = "810610";
        String name = "Allison";
        String lname = "Abrahams";
        String dateOfBirth = "10/06/1981";
        String address = "Cape Town";
        String contactNumber = "0721234567";
        int age = 38;

        Caretaker c = CaretakerFactory.getCaretaker(id, name, lname, dateOfBirth, address, contactNumber, age);
        System.out.println(c);
        Assert.assertNotNull(c.getCaretakerIDNumber());
    }
}
