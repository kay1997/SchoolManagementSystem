package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Caretaker;
import com.factory.people.CaretakerFactory;
import com.repository.people.impl.CaretakerRepositoryImpl;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CaretakerRepositoryImplTest {
    CaretakerRepositoryImpl repository;
    Caretaker caretaker;

    @Before
    public void setUp() throws Exception {

        repository = CaretakerRepositoryImpl.getRepository();
        caretaker = CaretakerFactory.getCaretaker("123", "K", "Adams", "97", "Cape Town", "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(caretaker);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(caretaker);
        assertNotNull(repository.read(caretaker.getCaretakerIDNumber()));
        System.out.println("Created\n" + repository.read(caretaker.getCaretakerIDNumber()));
    }

    @Test
    public void read() {

        repository.create(caretaker);

        Caretaker caretakers = repository.read(caretaker.getCaretakerIDNumber());

        assertEquals(caretaker, caretakers);
    }

    @Test
    public void update() {

        repository.create(caretaker);

        Caretaker updatedCaretaker = CaretakerFactory.getCaretaker("123", "Kaylen", "Adams", "97", "Cape Town", "0213920626", 22);

        repository.update(updatedCaretaker);

        Assert.assertNotEquals(caretaker.getCaretakerFirstName(), updatedCaretaker.getCaretakerFirstName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}
