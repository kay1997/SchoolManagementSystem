package com.factory.equipment;

import org.junit.Assert;
import org.junit.Test;
import com.domain.equipment.Textbook;

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