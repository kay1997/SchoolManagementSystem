package com.repository.admin;

import com.app.SchoolManagementSystemApplication;
import com.domain.admin.Class;
import com.factory.admin.ClassFactory;
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
public class ClassRepositoryImplTest {
    @Autowired
    private ClassRepository repository;
    private String oneClassNo = null;

    @Test
    public void CreateClassTest() throws IOException {
        Class oneClass = ClassFactory.getClass("A");
        Class result = repository.create(oneClass);
        oneClassNo = result.getClassGroup();
        Assert.assertNotNull(oneClass);
    }

    @Test
    public void GetClassTest() throws IOException {

        Class oneClass = repository.read(oneClassNo);
        Assert.assertNotNull(oneClass);
    }
}
