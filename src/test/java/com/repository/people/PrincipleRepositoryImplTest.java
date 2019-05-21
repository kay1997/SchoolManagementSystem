package com.repository.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Principle;
import com.factory.people.PrincipleFactory;
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
public class PrincipleRepositoryImplTest {
    @Autowired
    private PrincipleRepository repository;
    private String principleId = null;

    @Test
    public void CreatePrincipleTest() throws IOException {
        Principle principle = PrincipleFactory.getPrinciple("970826", "Kaylen", "Abrahams", "260897", "Strandloper", "0605220503", 22);
        Principle result = repository.create(principle);
        principleId = result.getPrincipleIDNumber();
        Assert.assertNotNull(principle);
    }

    @Test
    public void GetPrincipleTest() throws IOException {

        Principle principle = repository.read(principleId);
        Assert.assertNotNull(principle);
    }
}

