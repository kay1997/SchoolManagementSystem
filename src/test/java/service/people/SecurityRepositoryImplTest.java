package service.people;

import domain.people.Security;
import factory.people.SecurityFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.people.SecurityRepository;
import repository.people.impl.SecurityRepositoryImpl;

import java.util.Set;

import java.sql.SQLOutput;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecurityRepositoryImplTest {

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
        Security security = new Security.Builder().copy(getSavedSecurity()).securityFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + security);
        Security updated = this.repository.update(security);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSecurityFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Security> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}