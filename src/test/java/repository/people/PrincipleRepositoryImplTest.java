package repository.people;

import domain.people.Principle;
import factory.people.PrincipleFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.people.impl.PrincipleRepositoryImpl;
import repository.people.PrincipleRepository;

import java.util.Set;

public class PrincipleRepositoryImplTest {

    private PrincipleRepository repository;
    private Principle principle;

    private Principle getSavedPrinciple() {
        Set<Principle> savedPrinciples = this.repository.getAll();
        return savedPrinciples.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PrincipleRepositoryImpl.getRepository();
        this.principle = PrincipleFactory.getPrinciple("870912", "Kay", "Abrahams", "870912", "Cape Town", "0123456789", 32);
    }

    @Test
    public void a_create() {
        Principle created = this.repository.create(this.principle);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.principle);
    }

    @Test
    public void b_read() {
        Principle savedPrinciple = getSavedPrinciple();
        System.out.println("In read, principle ID number = " + savedPrinciple.getPrincipleIDNumber());
        Principle read = this.repository.read(savedPrinciple.getPrincipleIDNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedPrinciple, read);
    }

    @Test
    public void e_delete() {
        Principle savedPrinciple = getSavedPrinciple();
        this.repository.delete(savedPrinciple.getPrincipleIDNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Principle Name";
        Principle principle = new Principle.Builder().copy(getSavedPrinciple()).principleFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + principle);
        Principle updated = this.repository.update(principle);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getPrincipleFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Principle> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}