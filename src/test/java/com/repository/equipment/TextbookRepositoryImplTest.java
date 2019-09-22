package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Textbook;
import com.factory.equipment.TextbookFactory;
import com.repository.equipment.impl.TextbookRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class TextbookRepositoryImplTest {
    TextbookRepositoryImpl repository;
    Textbook textbook;

    @Before
    public void setUp() throws Exception {

        repository = TextbookRepositoryImpl.getRepository();
        textbook = TextbookFactory.getTextbook("I.T", "001");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(textbook);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(textbook);
        assertNotNull(repository.read(textbook.getTextbookCode()));
        System.out.println("Created\n" + repository.read(textbook.getTextbookCode()));
    }

    @Test
    public void read() {

        repository.create(textbook);

        Textbook textbooks = repository.read(textbook.getTextbookCode());

        assertEquals(textbook, textbooks);
    }

    @Test
    public void update() {

        repository.create(textbook);

        Textbook updatedTextbook = TextbookFactory.getTextbook("IT",  "001");

        repository.update(updatedTextbook);

        Assert.assertNotEquals(textbook.getTextbookName(), updatedTextbook.getTextbookName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}