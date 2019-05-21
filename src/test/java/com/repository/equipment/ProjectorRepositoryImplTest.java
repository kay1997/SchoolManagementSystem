package com.repository.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
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
public class ProjectorRepositoryImplTest {
    @Autowired
    private ProjectorRepository repository;
    private String projectorCode = null;

    @Test
    public void CreateProjectorTest() throws IOException {
        Projector projector = ProjectorFactory.getProjector("0124", "Samsung");
        Projector result = repository.create(projector);
        projectorCode = result.getProjectorCode();
        Assert.assertNotNull(projector);
    }

    @Test
    public void GetProjectorTest() throws IOException {

        Projector projector = repository.read(projectorCode);
        Assert.assertNotNull(projector);
    }
}
