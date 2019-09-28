package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Principle;
import com.factory.people.PrincipleFactory;
import com.repository.people.impl.PrincipleRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PrincipleRepositoryImplTest {
    PrincipleRepositoryImpl repository;
    Principle principle;

    @Before
    public void setUp() throws Exception {

        repository = PrincipleRepositoryImpl.getRepository();
        principle = PrincipleFactory.getPrinciple("123", "K", "Adams", "97", "Cape Town", "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(principle);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(principle);
        assertNotNull(repository.read(principle.getPrincipleIDNumber()));
        System.out.println("Created\n" + repository.read(principle.getPrincipleIDNumber()));
    }

    @Test
    public void read() {

        repository.create(principle);

        Principle principles = repository.read(principle.getPrincipleIDNumber());

        assertEquals(principle, principles);
    }

    @Test
    public void update() {

        repository.create(principle);

        Principle updatedPrinciple = PrincipleFactory.getPrinciple("123", "KKA", "Adams", "97", "Cape Town", "0213920626", 22);

        repository.update(updatedPrinciple);

        Assert.assertNotEquals(principle.getPrincipleFirstName(), updatedPrinciple.getPrincipleFirstName());
    }
    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}