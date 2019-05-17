package service.people;

import domain.people.Secretary;
import factory.people.SecretaryFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.people.SecretaryRepository;
import repository.people.impl.SecretaryRepositoryImpl;

import java.util.Set;

import java.sql.SQLOutput;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecretaryRepositoryImplTest {

    private SecretaryRepository repository;
    private Secretary secretary;

    private Secretary getSavedSecretary() {
        Set<Secretary> savedSecretaries = this.repository.getAll();
        return savedSecretaries.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SecretaryRepositoryImpl.getRepository();
        this.secretary = SecretaryFactory.getSecretary("880414", "Ally", "Adams", "880414", "Cape Town", "0875432134", 33);
    }

    @Test
    public void a_create() {
        Secretary created = this.repository.create(this.secretary);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.secretary);
    }

    @Test
    public void b_read() {
        Secretary savedSecretary = getSavedSecretary();
        System.out.println("In read, secretary ID number = " + savedSecretary.getSecretaryIDNumber());
        Secretary read = this.repository.read(savedSecretary.getSecretaryIDNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSecretary, read);
    }

    @Test
    public void e_delete() {
        Secretary savedSecretary = getSavedSecretary();
        this.repository.delete(savedSecretary.getSecretaryIDNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Secretary Name";
        Secretary secretary = new Secretary.Builder().copy(getSavedSecretary()).secretaryFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + secretary);
        Secretary updated = this.repository.update(secretary);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSecretaryFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Secretary> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}