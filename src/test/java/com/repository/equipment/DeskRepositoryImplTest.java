package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
import com.repository.equipment.impl.DeskRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class DeskRepositoryImplTest {
    DeskRepositoryImpl repository;
    Desk desk;

    @Before
    public void setUp() throws Exception {

        repository = DeskRepositoryImpl.getRepository();
        desk = DeskFactory.getDesk("002", "Wooden");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(desk);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(desk);
        assertNotNull(repository.read(desk.getDeskNumber()));
        System.out.println("Created\n" + repository.read(desk.getDeskNumber()));
    }

    @Test
    public void read() {

        repository.create(desk);

        Desk desks = repository.read(desk.getDeskNumber());

        assertEquals(desk, desks);
    }

    @Test
    public void update() {

        repository.create(desk);

        Desk updatedDesk = DeskFactory.getDesk("002",  "Plastic");

        repository.update(updatedDesk);

        Assert.assertNotEquals(desk.getDeskType(), updatedDesk.getDeskType());
    }
    @Test
    public void delete() {
        repository.delete("002");
        assertNull(repository.read("002"));
        System.out.println("Deleted\n" + repository.read("002"));
    }

}