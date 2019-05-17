package repository.assessments;

import domain.assessments.Assignment;
import factory.assessments.AssignmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;
import repository.assessments.AssignmentRepository;
import repository.assessments.impl.AssignmentRepositoryImpl;

import java.util.Set;

public class AssignmentRepositoryImplTest {

    private AssignmentRepository repository;
    private Assignment assignment;

    private Assignment getSavedAssignment() {
        Set<Assignment> savedAssignments = this.repository.getAll();
        return savedAssignments.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssignmentRepositoryImpl.getRepository();
        this.assignment = AssignmentFactory.getAssignment("Maths001", "Written");
    }

    @Test
    public void a_create() {
        Assignment created = this.repository.create(this.assignment);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.assignment);
    }

    @Test
    public void b_read() {
        Assignment savedAssignment = getSavedAssignment();
        System.out.println("In read, assignment number = " + savedAssignment.getAssignmentNumber());
        Assignment read = this.repository.read(savedAssignment.getAssignmentNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAssignment, read);
    }

    @Test
    public void e_delete() {
        Assignment savedAssignment = getSavedAssignment();
        this.repository.delete(savedAssignment.getAssignmentNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newAssignmentNumber = "New Test Assignment Number";
        Assignment assignment = new Assignment.Builder().copy(getSavedAssignment()).assignmentNumber(newAssignmentNumber).build();
        System.out.println("In update, about_to_updated = " + assignment);
        Assignment updated = this.repository.update(assignment);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAssignmentNumber, updated.getAssignmentNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assignment> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
