package com.repository.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
import com.repository.equipment.impl.StationeryRepositoryImpl;
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
public class StationeryRepositoryImplTest {
    StationeryRepositoryImpl repository;
    Stationery stationery;

    @Before
    public void setUp() throws Exception {

        repository = StationeryRepositoryImpl.getRepository();
        stationery = StationeryFactory.getStationery("112", "Pencil");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(stationery);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(stationery);
        assertNotNull(repository.read(stationery.getStationeryCode()));
        System.out.println("Created\n" + repository.read(stationery.getStationeryCode()));
    }

    @Test
    public void read() {

        repository.create(stationery);

        Stationery stationerySet = repository.read(stationery.getStationeryCode());

        assertEquals(stationery, stationerySet);
    }

    @Test
    public void update() {

        repository.create(stationery);

        Stationery updatedStationery = StationeryFactory.getStationery("112",  "Eraser");

        repository.update(updatedStationery);

        Assert.assertNotEquals(stationery.getStationeryType(), updatedStationery.getStationeryType());
    }

    @Test
    public void delete() {
        repository.delete("12345");
        assertNull(repository.read("12345"));
        System.out.println("Deleted\n" + repository.read("12345"));
    }

}