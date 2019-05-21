package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Result;
import com.factory.admin.ResultFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ResultRepositoryImplTest {
    @Autowired
    private ResultRepository repository;
    private String resultsNo = null;

    @Test
    public void CreateResultTest() throws IOException {
        Result results = ResultFactory.getResult("89");
        Result result = repository.create(results);
        resultsNo = result.getSubjectMark();
        Assert.assertNotNull(results);
    }

    @Test
    public void GetResultTest() throws IOException {

        Result results = repository.read(resultsNo);
        Assert.assertNotNull(results);
    }
}
