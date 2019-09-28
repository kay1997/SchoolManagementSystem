package com.service.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Room;
import com.factory.infrastructure.RoomFactory;
import com.service.infrastructure.impl.RoomServiceImpl;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
public class RoomServiceTest {

    RoomServiceImpl service;
    Room room;

    @Before
    public void setUp() throws Exception {
        service = RoomServiceImpl.getService();
        room = RoomFactory.getRoom("13", "Bathroom");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(room);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(room);
        assertNotNull(service.read("13"));
        System.out.println("Created\n" + service.read("13"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("13"));
        System.out.println("Read\n" + service.read("13"));
    }

    @Test
    public void update() {
        service.create(room);
        System.out.println(service.read("13"));

        Room roomUpdated = RoomFactory.getRoom("13", "Meeting");
        service.update(roomUpdated);

        Room r = service.read("13");
        Assert.assertNotEquals(room.getRoomType(), r.getRoomType());
        System.out.println("Updated\n" + service.read("13"));
    }

    @Test
    public void delete() {
        service.delete(room.getRoomNumber());
        assertNull(service.read(room.getRoomNumber()));
        System.out.println("Delete\n" + service.read(room.getRoomNumber()));
    }

}