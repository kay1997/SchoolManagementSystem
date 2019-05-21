package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Desk;
import com.factory.equipment.DeskFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.DeskRepository;
import com.repository.equipment.impl.DeskRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class DeskServiceTest {

        private DeskRepository repository;
        private Desk desk;

    private Desk getSavedDesk() {
        Set<Desk> savedDesks = this.repository.getAll();
        return savedDesks.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DeskRepositoryImpl.getRepository();
        this.desk = DeskFactory.getDesk("3");
    }

    @Test
    public void a_create() {
        Desk created = this.repository.create(this.desk);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.desk);
    }

    @Test
    public void b_read() {
        Desk savedDesk = getSavedDesk();
        System.out.println("In read, desk number = " + savedDesk.getDeskNumber());
        Desk read = this.repository.read(savedDesk.getDeskNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedDesk, read);
    }

    @Test
    public void e_delete() {
        Desk savedDesk = getSavedDesk();
        this.repository.delete(savedDesk.getDeskNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newDeskNumber = "New Test Desk Number";
        Desk updated = new Desk.Builder().copy(getSavedDesk()).deskNumber(newDeskNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newDeskNumber, updated.getDeskNumber());
    }

    @Test
    public void d_getAll() {
        Set<Desk> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
