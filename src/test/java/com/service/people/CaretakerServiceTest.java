package com.service.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Caretaker;
import com.factory.people.CaretakerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.CaretakerRepository;
import com.repository.people.impl.CaretakerRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class CaretakerServiceTest {

    private CaretakerRepository repository;
    private Caretaker caretaker;

    private Caretaker getSavedCaretaker() {
        Set<Caretaker> savedCaretakers = this.repository.getAll();
        return savedCaretakers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CaretakerRepositoryImpl.getRepository();
        this.caretaker = CaretakerFactory.getCaretaker("870912", "Kay", "Abrahams", "870912", "Cape Town", "0123456789", 32);
    }

    @Test
    public void a_create() {
        Caretaker created = this.repository.create(this.caretaker);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.caretaker);
    }

    @Test
    public void b_read() {
        Caretaker savedCaretaker = getSavedCaretaker();
        System.out.println("In read, caretaker ID number = " + savedCaretaker.getCaretakerIDNumber());
        Caretaker read = this.repository.read(savedCaretaker.getCaretakerIDNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCaretaker, read);
    }

    @Test
    public void e_delete() {
        Caretaker savedCaretaker = getSavedCaretaker();
        this.repository.delete(savedCaretaker.getCaretakerIDNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newContactNumber = "New Test Caretaker Contact Number";
        Caretaker updated = new Caretaker.Builder().copy(getSavedCaretaker()).caretakerContactNumber(newContactNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newContactNumber, updated.getCaretakerContactNumber());
    }

    @Test
    public void d_getAll() {
        Set<Caretaker> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}