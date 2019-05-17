package repository.people;

import domain.people.Educator;
import factory.people.EducatorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.people.impl.EducatorRepositoryImpl;
import repository.people.EducatorRepository;

import java.util.Set;

public class EducatorRepositoryImplTest {

    private EducatorRepository repository;
    private Educator educator;

    private Educator getSavedEducator() {
        Set<Educator> savedEducators = this.repository.getAll();
        return savedEducators.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EducatorRepositoryImpl.getRepository();
        this.educator = EducatorFactory.getEducator("870912", "Kay", "Abrahams", "870912", "Cape Town", "0123456789", 32);
    }

    @Test
    public void a_create() {
        Educator created = this.repository.create(this.educator);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.educator);
    }

    @Test
    public void b_read() {
        Educator savedEducator = getSavedEducator();
        System.out.println("In read, educator ID number = " + savedEducator.getEducatorIDNumber());
        Educator read = this.repository.read(savedEducator.getEducatorIDNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedEducator, read);
    }

    @Test
    public void e_delete() {
        Educator savedEducator = getSavedEducator();
        this.repository.delete(savedEducator.getEducatorIDNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Educator Name";
        Educator educator = new Educator.Builder().copy(getSavedEducator()).educatorFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + educator);
        Educator updated = this.repository.update(educator);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getEducatorFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Educator> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}