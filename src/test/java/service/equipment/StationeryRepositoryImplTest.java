package service.equipment;

import domain.equipment.Stationery;
import factory.equipment.StationeryFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.equipment.StationeryRepository;
import repository.equipment.impl.StationeryRepositoryImpl;

import java.util.Set;

import java.sql.SQLOutput;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StationeryRepositoryImplTest {


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
        Stationery stationery = new Stationery.Builder().copy(getSavedStationery()).stationeryCode(newStationeryCode).build();
        System.out.println("In update, about_to_updated = " + stationery);
        Stationery updated = this.repository.update(stationery);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newStationeryCode, updated.getStationeryCode());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Stationery> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
