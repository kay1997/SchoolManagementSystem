package com.repository.admin;

import app.SchoolManagementSystemApplication;
import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
import com.repository.admin.impl.ResultRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ResultRepositoryImplTest {
    ResultRepositoryImpl repository;
    Result result;

    @Before
    public void setUp() throws Exception {

        repository = ResultRepositoryImpl.getRepository();
        result = ResultFactory.getResult("970826", "65");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(result);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(result);
        assertNotNull(repository.read(result.getLearnerID()));
        System.out.println("Created\n" + repository.read(result.getLearnerID()));
    }

    @Test
    public void read() {

        repository.create(result);

        Result results = repository.read(result.getLearnerID());

        assertEquals(result, results);
    }

    @Test
    public void update() {

        repository.create(result);

        Result updatedResult = ResultFactory.getResult("970826",  "70");

        repository.update(updatedResult);

        Assert.assertNotEquals(result.getSubjectMark(), updatedResult.getSubjectMark());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}
