package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.ComputerRepository;
import com.repository.equipment.impl.ComputerRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ComputerServiceTest {

    private ComputerRepository repository;
    private Computer computer;

    private Computer getSavedComputer() {
        Set<Computer> savedComputers = this.repository.getAll();
        return savedComputers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ComputerRepositoryImpl.getRepository();
        this.computer = ComputerFactory.getComputer("1233", "Dell");
    }

    @Test
    public void a_create() {
        Computer created = this.repository.create(this.computer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.computer);
    }

    @Test
    public void b_read() {
        Computer savedComputer = getSavedComputer();
        System.out.println("In read, computer number = " + savedComputer.getComputerNumber());
        Computer read = this.repository.read(savedComputer.getComputerNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedComputer, read);
    }

    @Test
    public void e_delete() {
        Computer savedComputer = getSavedComputer();
        this.repository.delete(savedComputer.getComputerNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newComputerNumber = "New Test Computer Number";
        Computer updated = new Computer.Builder().copy(getSavedComputer()).computerNumber(newComputerNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newComputerNumber, updated.getComputerNumber());
    }

    @Test
    public void d_getAll() {
        Set<Computer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
