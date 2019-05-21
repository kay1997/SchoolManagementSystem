package com.service.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.admin.ResultRepository;
import com.repository.admin.impl.ResultRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ResultServiceTest {

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
        Result updated = new Result.Builder().copy(getSavedResult()).subjectMark(newResultCode).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newResultCode, updated.getSubjectMark());

    }

    @Test
    public void d_getAll() {
        Set<Result> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
