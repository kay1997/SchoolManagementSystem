package repository.equipment;

import domain.equipment.Projector;
import factory.equipment.ProjectorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.equipment.ProjectorRepository;
import repository.equipment.impl.ProjectorRepositoryImpl;

import java.util.Set;

public class ProjectorRepositoryImplTest {

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
        Projector projector = new Projector.Builder().copy(getSavedProjector()).projectorCode(newProjectorCode).build();
        System.out.println("In update, about_to_updated = " + projector);
        Projector updated = this.repository.update(projector);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newProjectorCode, updated.getProjectorCode());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Projector> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
