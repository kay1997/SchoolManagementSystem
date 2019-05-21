package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Textbook;
import com.factory.equipment.TextbookFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class TextbookRepositoryImplTest {
    @Autowired
    private TextbookRepository repository;
    private String textbookCode = null;

    @Test
    public void CreateTextbookTest() throws IOException {
        Textbook textbook = TextbookFactory.getTextbook("Maths", "M001");
        Textbook result = repository.create(textbook);
        textbookCode = result.getTextbookCode();
        Assert.assertNotNull(textbook);
    }

    @Test
    public void GetTextbookTest() throws IOException {

        Textbook textbook = repository.read(textbookCode);
        Assert.assertNotNull(textbook);
    }
}
