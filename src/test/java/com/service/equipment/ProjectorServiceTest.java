package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Projector;
import com.factory.equipment.ProjectorFactory;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ProjectorServiceTest {

    private ProjectorRepository repository;
    private Projector projector;

    private Projector getSavedProjector() {
        Set<Projector> savedProjectors = this.repository.getAll();
        return savedProjectors.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectorRepositoryImpl.getRepository();
        this.projector = ProjectorFactory.getProjector("321", "HP");
    }

    @Test
    public void a_create() {
        Projector created = this.repository.create(this.projector);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.projector);
    }

    @Test
    public void b_read() {
        Projector savedProjector = getSavedProjector();
        System.out.println("In read, projector code = " + savedProjector.getProjectorCode());
        Projector read = this.repository.read(savedProjector.getProjectorCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedProjector, read);
    }

    @Test
    public void e_delete() {
        Projector savedProjector = getSavedProjector();
        this.repository.delete(savedProjector.getProjectorCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newProjectorCode = "New Test Projector Code";
        Projector updated = new Projector.Builder().copy(getSavedProjector()).projectorCode(newProjectorCode).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newProjectorCode, updated.getProjectorCode());
    }

    @Test
    public void d_getAll() {
        Set<Projector> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
