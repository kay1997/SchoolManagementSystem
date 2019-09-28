package com.repository.people;

import app.SchoolManagementSystemApplication;
import com.domain.people.Educator;
import com.factory.people.EducatorFactory;
import com.repository.people.impl.EducatorRepositoryImpl;
import org.junit.*;
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
public class EducatorRepositoryTest {
    EducatorRepositoryImpl repository;
    Educator educator;

    @Before
    public void setUp() throws Exception {

        repository = EducatorRepositoryImpl.getRepository();
        educator = EducatorFactory.getEducator("123", "K", "Adams", "97", "Cape Town", "0213920626", 22);
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(educator);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(educator);
        assertNotNull(repository.read(educator.getEducatorIDNumber()));
        System.out.println("Created\n" + repository.read(educator.getEducatorIDNumber()));
    }

    @Test
    public void read() {

        repository.create(educator);

        Educator educators = repository.read(educator.getEducatorIDNumber());

        assertEquals(educator, educators);
    }

    @Test
    public void update() {

        repository.create(educator);

        Educator updatedEducator = EducatorFactory.getEducator("123", "Kevin", "Adams", "97", "Cape Town", "0213920626", 22);

        repository.update(updatedEducator);

        Assert.assertNotEquals(educator.getEducatorFirstName(), updatedEducator.getEducatorFirstName());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}