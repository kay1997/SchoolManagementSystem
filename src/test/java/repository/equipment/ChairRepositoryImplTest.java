package repository.equipment;

import domain.equipment.Chair;
import factory.equipment.ChairFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.equipment.ChairRepository;
import repository.equipment.impl.ChairRepositoryImpl;

import java.util.Set;

public class ChairRepositoryImplTest {


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
        Chair chair = new Chair.Builder().copy(getSavedChair()).chairNumber(newChairNumber).build();
        System.out.println("In update, about_to_updated = " + chair);
        Chair updated = this.repository.update(chair);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newChairNumber, updated.getChairNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Chair> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
