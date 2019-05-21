package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Subject;
import com.factory.admin.SubjectFactory;
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
public class SubjectRepositoryImplTest {
    @Autowired
    private SubjectRepository repository;
    private String subjectNo = null;

    @Test
    public void CreateSubjectTest() throws IOException {
        Subject subject = SubjectFactory.getSubject("Acc1", "Accounting");
        Subject result = repository.create(subject);
        subjectNo = result.getSubjectCode();
        Assert.assertNotNull(subject);
    }

    @Test
    public void GetSubjectTest() throws IOException {

        Subject subject = repository.read(subjectNo);
        Assert.assertNotNull(subject);
    }
}
