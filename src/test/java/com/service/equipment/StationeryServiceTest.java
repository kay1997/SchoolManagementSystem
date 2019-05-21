package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Stationery;
import com.factory.equipment.StationeryFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.StationeryRepository;
import com.repository.equipment.impl.StationeryRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class StationeryServiceTest {


    private StationeryRepository repository;
    private Stationery stationery;

    private Stationery getSavedStationery() {
        Set<Stationery> savedStationerySet = this.repository.getAll();
        return savedStationerySet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StationeryRepositoryImpl.getRepository();
        this.stationery = StationeryFactory.getStationery("PEN123", "Pen");
    }

    @Test
    public void a_create() {
        Stationery created = this.repository.create(this.stationery);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.stationery);
    }

    @Test
    public void b_read() {
        Stationery savedStationery = getSavedStationery();
        System.out.println("In read, stationery code = " + savedStationery.getStationeryCode());
        Stationery read = this.repository.read(savedStationery.getStationeryCode());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStationery, read);
    }

    @Test
    public void e_delete() {
        Stationery savedStationery = getSavedStationery();
        this.repository.delete(savedStationery.getStationeryCode());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newStationeryCode = "New Test Stationery Code";
        Stationery updated = new Stationery.Builder().copy(getSavedStationery()).stationeryCode(newStationeryCode).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStationeryCode, updated.getStationeryCode());
    }

    @Test
    public void d_getAll() {
        Set<Stationery> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
