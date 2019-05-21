package com.service.people;

import com.app.SchoolManagementSystemApplication;
import com.domain.people.Security;
import com.factory.people.SecurityFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.people.SecurityRepository;
import com.repository.people.impl.SecurityRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class SecurityServiceTest {

    private SecurityRepository repository;
    private Security security;

    private Security getSavedSecurity() {
        Set<Security> savedSecurities = this.repository.getAll();
        return savedSecurities.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SecurityRepositoryImpl.getRepository();
        this.security = SecurityFactory.getSecurity("870912", "Kay", "Abrahams", "870912", "Cape Town", "0123456789", 32);
    }

    @Test
    public void a_create() {
        Security created = this.repository.create(this.security);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.security);
    }

    @Test
    public void b_read() {
        Security savedSecurity = getSavedSecurity();
        System.out.println("In read, security ID number = "+ savedSecurity.getSecurityIDNumber());
        Security read = this.repository.read(savedSecurity.getSecurityIDNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSecurity, read);
    }

    @Test
    public void e_delete() {
        Security savedSecurity = getSavedSecurity();
        this.repository.delete(savedSecurity.getSecurityIDNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Security Name";
        Security updated = new Security.Builder().copy(getSavedSecurity()).securityFirstName(newname).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newname, updated.getSecurityFirstName());
    }

    @Test
    public void d_getAll() {
        Set<Security> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}