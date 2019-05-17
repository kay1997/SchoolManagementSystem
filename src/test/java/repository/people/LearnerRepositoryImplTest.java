package repository.people;

import domain.people.Learner;
import factory.people.LearnerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.people.impl.LearnerRepositoryImpl;
import repository.people.LearnerRepository;

import java.util.Set;

public class LearnerRepositoryImplTest {


    private LearnerRepository repository;
    private Learner learner;

    private Learner getSavedLearner() {
        Set<Learner> savedSecurities = this.repository.getAll();
        return savedSecurities.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LearnerRepositoryImpl.getRepository();
        this.learner = LearnerFactory.getLearner("870912", "Kay", "Abrahams", "Cape Town", "1234567890", 15);
    }

    @Test
    public void a_create() {
        Learner created = this.repository.create(this.learner);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.learner);
    }

    @Test
    public void b_read() {
        Learner savedLearner = getSavedLearner();
        System.out.println("In read, learner ID number = " + savedLearner.getLearnerId());
        Learner read = this.repository.read(savedLearner.getLearnerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedLearner, read);
    }

    @Test
    public void e_delete() {
        Learner savedLearner = getSavedLearner();
        this.repository.delete(savedLearner.getLearnerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Learner Name";
        Learner learner = new Learner.Builder().copy(getSavedLearner()).learnerFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + learner);
        Learner updated = this.repository.update(learner);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getLearnerFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Learner> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}