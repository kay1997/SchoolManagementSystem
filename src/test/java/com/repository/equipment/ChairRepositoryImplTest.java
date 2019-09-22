package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
import com.repository.equipment.impl.ChairRepositoryImpl;
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
public class ChairRepositoryImplTest {
    ChairRepositoryImpl repository;
    Chair chair;

    @Before
    public void setUp() throws Exception {

        repository = ChairRepositoryImpl.getRepository();
        chair = ChairFactory.getChair("002", "Steel");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(chair);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(chair);
        assertNotNull(repository.read(chair.getChairNumber()));
        System.out.println("Created\n" + repository.read(chair.getChairNumber()));
    }

    @Test
    public void read() {

        repository.create(chair);

        Chair chairs = repository.read(chair.getChairNumber());

        assertEquals(chair, chairs);
    }

    @Test
    public void update() {

        repository.create(chair);

        Chair updatedChair = ChairFactory.getChair("002",  "Wooden");

        repository.update(updatedChair);

        Assert.assertNotEquals(chair.getChairType(), updatedChair.getChairType());
    }

    @Test
    public void delete() {
        repository.delete("002");
        assertNull(repository.read("002"));
        System.out.println("Deleted\n" + repository.read("002"));
    }

}