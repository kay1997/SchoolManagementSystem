package com.service.equipment;

import com.app.SchoolManagementSystemApplication;
import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repository.equipment.ChairRepository;
import com.repository.equipment.impl.ChairRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ChairServiceTest {


    private ChairRepository repository;
    private Chair chair;

    private Chair getSavedChair() {
        Set<Chair> savedChairs = this.repository.getAll();
        return savedChairs.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ChairRepositoryImpl.getRepository();
        this.chair = ChairFactory.getChair("3");
    }

    @Test
    public void a_create() {
        Chair created = this.repository.create(this.chair);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.chair);
    }

    @Test
    public void b_read() {
        Chair savedChair = getSavedChair();
        System.out.println("In read, chair number = " + savedChair.getChairNumber());
        Chair read = this.repository.read(savedChair.getChairNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedChair, read);
    }

    @Test
    public void e_delete() {
        Chair savedChair = getSavedChair();
        this.repository.delete(savedChair.getChairNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newChairNumber = "New Test Chair Number";
        Chair updated = new Chair.Builder().copy(getSavedChair()).chairNumber(newChairNumber).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newChairNumber, updated.getChairNumber());
    }

    @Test
    public void d_getAll() {
        Set<Chair> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
