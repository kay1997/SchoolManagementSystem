package repository.admin;

import domain.admin.Subject;
import factory.admin.SubjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.admin.SubjectRepository;
import repository.admin.impl.SubjectRepositoryImpl;

import java.util.Set;

public class SubjectRepositoryImplTest {

    private SubjectRepository repository;
    private Subject subject;

    private Subject getSavedSubject() {
        Set<Subject> savedSubjects = this.repository.getAll();
        return savedSubjects.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SubjectRepositoryImpl.getRepository();
        this.subject = SubjectFactory.getSubject("Maths01", "Mathematics");
    }

    @Test
    public void a_create() {
        Subject created = this.repository.create(this.subject);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void b_read() {
        Subject savedSubject = getSavedSubject();
        System.out.println("In read, subject code = " + savedSubject.getSubjectCode());
        Subject read = this.repository.read(savedSubject.getSubjectCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSubject, read);
    }

    @Test
    public void e_delete() {
        Subject savedSubject = getSavedSubject();
        this.repository.delete(savedSubject.getSubjectCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newSubjectCode = "New Test Subject Code";
        Subject subject = new Subject.Builder().copy(getSavedSubject()).subjectCode(newSubjectCode).build();
        System.out.println("In update, about_to_updated = " + subject);
        Subject updated = this.repository.update(subject);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newSubjectCode, updated.getSubjectCode());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Subject> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
