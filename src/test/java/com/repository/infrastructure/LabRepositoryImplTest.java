package com.repository.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Lab;
import com.factory.infrastructure.LabFactory;
import com.repository.infrastructure.impl.LabRepositoryImpl;
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
public class LabRepositoryImplTest {
    LabRepositoryImpl repository;
    Lab lab;

    @Before
    public void setUp() throws Exception {

        repository = LabRepositoryImpl.getRepository();
        lab = LabFactory.getLab("002", "Computer");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(lab);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(lab);
        assertNotNull(repository.read(lab.getLabNumber()));
        System.out.println("Created\n" + repository.read(lab.getLabNumber()));
    }

    @Test
    public void read() {

        repository.create(lab);

        Lab labs = repository.read(lab.getLabNumber());

        assertEquals(lab, labs);
    }

    @Test
    public void update() {

        repository.create(lab);

        Lab updatedLab = LabFactory.getLab("002",  "Medical");

        repository.update(updatedLab);

        Assert.assertNotEquals(lab.getLabType(), updatedLab.getLabType());
    }
    @Test
    public void delete() {
        repository.delete("002");
        assertNull(repository.read("002"));
        System.out.println("Deleted\n" + repository.read("002"));
    }

}