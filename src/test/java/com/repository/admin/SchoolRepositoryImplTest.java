package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.School;
import com.factory.admin.SchoolFactory;
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
public class SchoolRepositoryImplTest {
    @Autowired
    private SchoolRepository repository;
    private String schoolNo = null;

    @Test
    public void CreateSchoolTest() throws IOException {
        School school = SchoolFactory.getSchool("S11", "Seaview", "Rocklands", "0213921234");
        School result = repository.create(school);
        schoolNo = result.getSchoolCode();
        Assert.assertNotNull(school);
    }

    @Test
    public void GetSchoolTest() throws IOException {

        School school = repository.read(schoolNo);
        Assert.assertNotNull(school);
    }
}
