package com.repository.infrastructure;

import com.app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Lab;
import com.factory.infrastructure.LabFactory;
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
public class LabRepositoryImplTest {
    @Autowired
    private LabRepository repository;
    private String labNo = null;

    @Test
    public void CreateLabTest() throws IOException {
        Lab lab = LabFactory.getLab("1", "Computer");
        Lab result = repository.create(lab);
        labNo = result.getLabNumber();
        Assert.assertNotNull(lab);
    }

    @Test
    public void GetLabTest() throws IOException {

        Lab lab = repository.read(labNo);
        Assert.assertNotNull(lab);
    }
}
