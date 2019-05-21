package com.service.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.EducatorRepository;
import com.repository.people.impl.EducatorRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class EducatorServiceTest {

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

   /* @Test
    public void c_update() {
        String newname = "New Test Educator Name";
        Educator updated = new Educator.Builder().copy(getSavedEducator()).educatorFirstName(newname).build();
        System.out.println("In update, updated = " + updated);
        this.com.repository.update(updated);
        Assert.assertSame(newname, updated.getEducatorFirstName());

    }*/

    @Test
    public void d_getAll() {
        Set<Educator> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}