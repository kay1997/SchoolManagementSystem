package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
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
public class ChairRepositoryImplTest {
    @Autowired
    private ChairRepository repository;
    private String chairNo = null;

    @Test
    public void CreateChairTest() throws IOException {
        Chair chair = ChairFactory.getChair( "22");
        Chair result = repository.create(chair);
        chairNo = result.getChairNumber();
        Assert.assertNotNull(chair);
    }

    @Test
    public void GetChairTest() throws IOException {

        Chair chair = repository.read(chairNo);
        Assert.assertNotNull(chair);
    }
}
