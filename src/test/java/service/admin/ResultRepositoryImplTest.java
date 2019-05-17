package service.admin;

import domain.admin.Result;
import factory.admin.ResultFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.admin.ResultRepository;
import repository.admin.impl.ResultRepositoryImpl;

import java.util.Set;

import java.sql.SQLOutput;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResultRepositoryImplTest {

    private ResultRepository repository;
    private Result result;

    private Result getSavedResult() {
        Set<Result> savedResults = this.repository.getAll();
        return savedResults.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ResultRepositoryImpl.getRepository();
        this.result = ResultFactory.getResult("89");
    }

    @Test
    public void a_create() {
        Result created = this.repository.create(this.result);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.result);
    }

    @Test
    public void b_read() {
        Result savedResult = getSavedResult();
        System.out.println("In read, result code = " + savedResult.getSubjectMark());
        Result read = this.repository.read(savedResult.getSubjectMark());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedResult, read);
    }

    @Test
    public void e_delete() {
        Result savedResult = getSavedResult();
        this.repository.delete(savedResult.getSubjectMark());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newResultCode = "New Test Subject Mark";
        Result result = new Result.Builder().copy(getSavedResult()).subjectMark(newResultCode).build();
        System.out.println("In update, about_to_updated = " + result);
        Result updated = this.repository.update(result);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newResultCode, updated.getSubjectMark());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Result> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
