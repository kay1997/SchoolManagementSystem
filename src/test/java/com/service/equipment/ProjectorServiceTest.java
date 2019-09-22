package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
import com.service.equipment.impl.ProjectorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.ProjectorRepository;
import com.repository.equipment.impl.ProjectorRepositoryImpl;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ProjectorServiceTest {

    ProjectorServiceImpl service;
    Projector projector;

    @Before
    public void setUp() throws Exception {
        service = ProjectorServiceImpl.getService();
        projector = ProjectorFactory.getProjector("12345", "Dell");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(projector);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(projector);
        assertNotNull(service.read("12345"));
        System.out.println("Created\n" + service.read("12345"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("12345"));
        System.out.println("Read\n" + service.read("12345"));
    }

    @Test
    public void update() {
        service.create(projector);
        System.out.println(service.read("12345"));

        Projector projectorUpdated = ProjectorFactory.getProjector("12345", "Samsung");
        service.update(projectorUpdated);

        Projector pro = service.read("12345");
        Assert.assertNotEquals(projector.getProjectorName(), pro.getProjectorName());
        System.out.println("Updated\n" + service.read("12345"));
    }

    @Test
    public void delete() {
        service.delete("12345");
        assertNull(service.read(projector.getProjectorCode()));
        System.out.println("Delete\n" + service.read(projector.getProjectorCode()));
    }

}