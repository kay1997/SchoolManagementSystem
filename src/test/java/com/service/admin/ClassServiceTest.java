package com.service.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.ClassRepository;
import com.repository.admin.impl.ClassRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ClassServiceTest {


    private ClassRepository repository;
    private Class oneClass;

    private Class getSavedClass() {
        Set<Class> savedClasses = this.repository.getAll();
        return savedClasses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ClassRepositoryImpl.getRepository();
        this.oneClass = ClassFactory.getClass("A");
    }

    @Test
    public void a_create() {
        Class created = this.repository.create(this.oneClass);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.oneClass);
    }

    @Test
    public void b_read() {
        Class savedClass = getSavedClass();
        System.out.println("In read, class group = " + savedClass.getClassGroup());
        Class read = this.repository.read(savedClass.getClassGroup());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedClass, read);
    }

    @Test
    public void e_delete() {
        Class savedPrinter = getSavedClass();
        this.repository.delete(getSavedClass().getClassGroup());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newClassGroup = "New Test Class Group";
        Class updated = new Class.Builder().copy(getSavedClass()).classGroup(newClassGroup).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newClassGroup, updated.getClassGroup());
    }

    @Test
    public void d_getAll() {
        Set<Class> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
