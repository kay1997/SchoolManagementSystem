package com.repository.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Security;
import com.factory.people.SecurityFactory;
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
public class SecurityRepositoryImplTest {
    @Autowired
    private SecurityRepository repository;
    private String securityId = null;

    @Test
    public void CreateSecurityTest() throws IOException {
        Security security = SecurityFactory.getSecurity("970826", "Kaylen", "Abrahams", "260897", "Strandloper", "0605220503", 22);
        Security result = repository.create(security);
        securityId = result.getSecurityIDNumber();
        Assert.assertNotNull(security);
    }

    @Test
    public void GetSecurityTest() throws IOException {

        Security security = repository.read(securityId);
        Assert.assertNotNull(security);
    }
}