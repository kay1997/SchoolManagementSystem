package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Textbook;
import com.factory.equipment.TextbookFactory;
import com.service.equipment.impl.TextbookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class TextbookServiceTest {

    TextbookServiceImpl service;
    Textbook textbook;

    @Before
    public void setUp() throws Exception {
        service = TextbookServiceImpl.getService();
        textbook = TextbookFactory.getTextbook("IT", "12345");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(textbook);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(textbook);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(textbook);
        System.out.println(service.read("12345"));

        Textbook textbookUpdated = TextbookFactory.getTextbook("English", "12345");
        service.update(textbookUpdated);

        Textbook txtBook = service.read("12345");
        Assert.assertNotEquals(textbook.getTextbookName(), txtBook.getTextbookName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(textbook.getTextbookCode()));
        System.out.println("Delete\n" + service.read(textbook.getTextbookCode()));
    }

}