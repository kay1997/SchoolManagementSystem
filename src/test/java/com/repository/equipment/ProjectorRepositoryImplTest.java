package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
import com.repository.equipment.impl.ProjectorRepositoryImpl;
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
public class ProjectorRepositoryImplTest {
    ProjectorRepositoryImpl repository;
    Projector projector;

    @Before
    public void setUp() throws Exception {

        repository = ProjectorRepositoryImpl.getRepository();
        projector = ProjectorFactory.getProjector("190", "Samsung");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(projector);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(projector);
        assertNotNull(repository.read(projector.getProjectorCode()));
        System.out.println("Created\n" + repository.read(projector.getProjectorCode()));
    }

    @Test
    public void read() {

        repository.create(projector);

        Projector projectors = repository.read(projector.getProjectorCode());

        assertEquals(projector, projectors);
    }

    @Test
    public void update() {

        repository.create(projector);

        Projector updatedProjector = ProjectorFactory.getProjector("3",  "Canon");

        repository.update(updatedProjector);

        Assert.assertNotEquals(projector.getProjectorName(), updatedProjector.getProjectorName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}