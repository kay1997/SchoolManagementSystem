package com.service.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Secretary;
import com.factory.people.SecretaryFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.SecretaryRepository;
import com.repository.people.impl.SecretaryRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SecretaryServiceTest {

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
        Secretary updated = new Secretary.Builder().copy(getSavedSecretary()).secretaryFirstName(newname).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newname, updated.getSecretaryFirstName());
    }

    @Test
    public void d_getAll() {
        Set<Secretary> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}