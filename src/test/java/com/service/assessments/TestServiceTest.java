package com.service.assessments;

import com.app.SchoolManagementSystemApplication;
import com.domain.assessments.Test;
import com.factory.assessments.TestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.assessments.TestRepository;
import com.repository.assessments.impl.TestRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class TestServiceTest {

    private TestRepository repository;
    private Test test;

    private Test getSavedTest() {
        Set<Test> savedTests = this.repository.getAll();
        return savedTests.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TestRepositoryImpl.getRepository();
        this.test = TestFactory.getTest("321", "Practical");
    }

    @org.junit.Test
    public void a_create() {
        Test created = this.repository.create(this.test);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.test);
    }

    @org.junit.Test
    public void b_read() {
        Test savedTest = getSavedTest();
        System.out.println("In read, test code = " + savedTest.getTestPaperNumber());
        Test read = this.repository.read(savedTest.getTestPaperNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTest, read);
    }

    @org.junit.Test
    public void e_delete() {
        Test savedTest = getSavedTest();
        this.repository.delete(savedTest.getTestPaperNumber());
        d_getAll();
    }

    @org.junit.Test
    public void c_update() {
        String newTestPaperNumber = "New Test Test Paper Number";
        Test updated = new Test.Builder().copy(getSavedTest()).testPaperNumber(newTestPaperNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTestPaperNumber, updated.getTestPaperNumber());
    }

    @org.junit.Test
    public void d_getAll() {
        Set<Test> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
