package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Computer;
import com.factory.equipment.ComputerFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ComputerRepositoryImplTest {
    @Autowired
    private ComputerRepository repository;
    private String computerNo = null;

    @Test
    public void CreateComputerTest() throws IOException {
        Computer computer = ComputerFactory.getComputer("1234", "Dell");
        Computer result = repository.create(computer);
        computerNo = result.getComputerNumber();
        Assert.assertNotNull(computer);
    }

    @Test
    public void GetComputerTest() throws IOException {

        Computer computer = repository.read(computerNo);
        Assert.assertNotNull(computer);
    }
}
