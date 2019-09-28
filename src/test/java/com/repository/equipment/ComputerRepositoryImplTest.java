package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
import com.repository.equipment.impl.ComputerRepositoryImpl;
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
public class ComputerRepositoryImplTest {
    ComputerRepositoryImpl repository;
    Computer computer;

    @Before
    public void setUp() throws Exception {

        repository = ComputerRepositoryImpl.getRepository();
        computer = ComputerFactory.getComputer("112", "Dell");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(computer);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(computer);
        assertNotNull(repository.read(computer.getComputerNumber()));
        System.out.println("Created\n" + repository.read(computer.getComputerNumber()));
    }

    @Test
    public void read() {

        repository.create(computer);

        Computer computers = repository.read(computer.getComputerNumber());

        assertEquals(computer, computers);
    }

    @Test
    public void update() {

        repository.create(computer);

        Computer updatedComputer = ComputerFactory.getComputer("112",  "Mac");

        repository.update(updatedComputer);

        Assert.assertNotEquals(computer.getComputerName(), updatedComputer.getComputerName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}