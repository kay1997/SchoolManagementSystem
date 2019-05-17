package service.admin;

import domain.admin.Grade;
import factory.admin.GradeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.admin.GradeRepository;
import repository.admin.impl.GradeRepositoryImpl;

import java.sql.SQLOutput;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeRepositoryImplTest {


    private GradeRepository repository;
    private Grade grade;

    private Grade getSavedGrade() {
        Set<Grade> savedGrades = this.repository.getAll();
        return savedGrades.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GradeRepositoryImpl.getRepository();
        this.grade = GradeFactory.getGrade("7");
    }

    @Test
    public void a_create() {
        Grade created = this.repository.create(this.grade);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.grade);
    }

    @Test
    public void b_read() {
        Grade savedGrade = getSavedGrade();
        System.out.println("In read, grade number = " + savedGrade.getGradeNumber());
        Grade read = this.repository.read(savedGrade.getGradeNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedGrade, read);
    }

    @Test
    public void e_delete() {
        Grade savedGrade = getSavedGrade();
        this.repository.delete(savedGrade.getGradeNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newGradeNumber = "New Test Grade Number";
        Grade grade = new Grade.Builder().copy(getSavedGrade()).gradeNumber(newGradeNumber).build();
        System.out.println("In update, about_to_updated = " + grade);
        Grade updated = this.repository.update(grade);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newGradeNumber, updated.getGradeNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Grade> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
