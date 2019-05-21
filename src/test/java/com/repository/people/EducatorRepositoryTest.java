package com.repository.people;

import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import com.app.SchoolManagementSystemApplication;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class EducatorRepositoryTest {
    @Autowired
    private EducatorRepository repository;
    private String educatorId=null;

    @Test
    public void EducatorCreateTest() throws IOException {
        Educator educator = EducatorFactory.getEducator("970826", "Kaylen", "Abrahams","260897", "Strandloper", "0605220503",  22);
        Educator result = repository.create(educator);
        educatorId = result.getEducatorIDNumber();
        Assert.assertNotNull(educator);
    }

    @Test
    public void SiteEducatorTest() throws IOException{
        Educator educator = repository.read(educatorId);
        Assert.assertNotNull(educator);
    }

}