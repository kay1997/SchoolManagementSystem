package repository.infrastructure;

import domain.infrastructure.Lab;
import factory.infrastructure.LabFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.infrastructure.impl.LabRepositoryImpl;
import repository.infrastructure.LabRepository;

import java.util.Set;

public class LabRepositoryImplTest {

    private LabRepository repository;
    private Lab lab;

    private Lab getSavedLab() {
        Set<Lab> savedLabs = this.repository.getAll();
        return savedLabs.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LabRepositoryImpl.getRepository();
        this.lab = LabFactory.getLab("3", "Computer");
    }

    @Test
    public void a_create() {
        Lab created = this.repository.create(this.lab);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.lab);
    }

    @Test
    public void b_read() {
        Lab savedLab = getSavedLab();
        System.out.println("In read, lab number = " + savedLab.getLabNumber());
        Lab read = this.repository.read(savedLab.getLabNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedLab, read);
    }

    @Test
    public void e_delete() {
        Lab savedLab = getSavedLab();
        this.repository.delete(savedLab.getLabNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newLabNumber = "New Test Lab Contact Number";
        Lab lab = new Lab.Builder().copy(getSavedLab()).labNumber(newLabNumber).build();
        System.out.println("In update, about_to_updated = " + lab);
        Lab updated = this.repository.update(lab);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newLabNumber, updated.getLabNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Lab> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
