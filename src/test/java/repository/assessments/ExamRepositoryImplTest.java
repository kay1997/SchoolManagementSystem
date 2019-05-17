package repository.assessments;

import domain.assessments.Exam;
import factory.assessments.ExamFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.assessments.ExamRepository;
import repository.assessments.impl.ExamRepositoryImpl;

import java.util.Set;

public class ExamRepositoryImplTest {

    private ExamRepository repository;
    private Exam exam;

    private Exam getSavedExam() {
        Set<Exam> savedExams = this.repository.getAll();
        return savedExams.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ExamRepositoryImpl.getRepository();
        this.exam = ExamFactory.getExam("Art321", "Written");
    }

    @Test
    public void a_create() {
        Exam created = this.repository.create(this.exam);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.exam);
    }

    @Test
    public void b_read() {
        Exam savedExam = getSavedExam();
        System.out.println("In read, exam code = " + savedExam.getExamPaperNumber());
        Exam read = this.repository.read(savedExam.getExamPaperNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedExam, read);
    }

    @Test
    public void e_delete() {
        Exam savedExam = getSavedExam();
        this.repository.delete(savedExam.getExamPaperNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newExamCode = "New Test Exam Paper Number";
        Exam exam = new Exam.Builder().copy(getSavedExam()).examPaperNumber(newExamCode).build();
        System.out.println("In update, about_to_updated = " + exam);
        Exam updated = this.repository.update(exam);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newExamCode, updated.getExamPaperNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Exam> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
