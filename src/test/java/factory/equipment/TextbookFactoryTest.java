package factory.equipment;

import factory.equipment.TextbookFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.equipment.Textbook;

public class TextbookFactoryTest {

    @Test
    public void getTextbookName() {

        String name = "I.T";
        String code = "001I.T";

        Textbook textbook = TextbookFactory.getTextbook(name, code);
        System.out.println(textbook);
        Assert.assertNotNull(textbook.getTextbookName());
    }
}