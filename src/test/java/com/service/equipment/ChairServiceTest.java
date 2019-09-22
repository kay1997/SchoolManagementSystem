package com.service.equipment;

import app.SchoolManagementSystemApplication;
import com.domain.equipment.Chair;
import com.factory.equipment.ChairFactory;
import com.service.equipment.impl.ChairServiceImpl;
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

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class ChairServiceTest {

    ChairServiceImpl service;
    Chair chair;

    @Before
    public void setUp() throws Exception {
        service = ChairServiceImpl.getService();
        chair = ChairFactory.getChair("1", "Plastic");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(chair);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(chair);
        assertNotNull(service.read("1"));
        System.out.println("Created\n" + service.read("1"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("1"));
        System.out.println("Read\n" + service.read("1"));
    }

    @Test
    public void update() {
        service.create(chair);
        System.out.println(service.read("1"));

        Chair chairUpdated = ChairFactory.getChair("1", "Wooden");
        service.update(chairUpdated);

        Chair chai = service.read("1");
        Assert.assertNotEquals(chair.getChairType(), chai.getChairType());
        System.out.println("Updated\n" + service.read("1"));
    }

    @Test
    public void delete() {
        service.delete(chair.getChairNumber());
        assertNull(service.read(chair.getChairNumber()));
        System.out.println("Delete\n" + service.read(chair.getChairNumber()));
    }

}