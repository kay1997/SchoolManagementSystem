package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
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
public class DeskRepositoryImplTest {
    @Autowired
    private DeskRepository repository;
    private String deskNo = null;

    @Test
    public void CreateDeskTest() throws IOException {
        Desk desk = DeskFactory.getDesk("21");
        Desk result = repository.create(desk);
        deskNo = result.getDeskNumber();
        Assert.assertNotNull(desk);
    }

    @Test
    public void GetDeskTest() throws IOException {

        Desk desk = repository.read(deskNo);
        Assert.assertNotNull(desk);
    }
}
