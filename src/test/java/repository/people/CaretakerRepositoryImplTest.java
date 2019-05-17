package repository.people;

import domain.people.Caretaker;
import factory.people.CaretakerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.people.impl.CaretakerRepositoryImpl;
import repository.people.CaretakerRepository;

import java.util.Set;

public class CaretakerRepositoryImplTest {

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
        Caretaker caretaker = new Caretaker.Builder().copy(getSavedCaretaker()).caretakerContactNumber(newContactNumber).build();
        System.out.println("In update, about_to_updated = " + caretaker);
        Caretaker updated = this.repository.update(caretaker);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newContactNumber, updated.getCaretakerContactNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Caretaker> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}