package com.repository.assessments;

import com.app.SchoolManagementSystemApplication;
import com.factory.assessments.TestFactory;
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
public class TestRepositoryImplTest {
    @Autowired
    private TestRepository repository;
    private String testNo = null;

    @Test
    public void CreateTestTest() throws IOException {
        com.domain.assessments.Test test = TestFactory.getTest("3", "Practical");
        com.domain.assessments.Test result = repository.create(test);
        testNo =  result.getTestPaperNumber();
        Assert.assertNotNull(test);
    }

    @Test
    public void GetTestTest() throws IOException {

        com.domain.assessments.Test test = repository.read(testNo);
        Assert.assertNotNull(test);
    }
}
