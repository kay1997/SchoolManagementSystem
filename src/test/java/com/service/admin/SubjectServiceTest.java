package com.service.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.SubjectRepository;
import com.repository.admin.impl.SubjectRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SubjectServiceTest {

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
        Subject updated = new Subject.Builder().copy(getSavedSubject()).subjectCode(newSubjectCode).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSubjectCode, updated.getSubjectCode());
    }

    @Test
    public void d_getAll() {
        Set<Subject> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
