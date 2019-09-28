package com.repository.infrastructure;

import app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Room;
import com.factory.infrastructure.RoomFactory;
import com.repository.infrastructure.impl.RoomRepositoryImpl;
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
public class RoomRepositoryImplTest {
    RoomRepositoryImpl repository;
    Room room;

    @Before
    public void setUp() throws Exception {

        repository = RoomRepositoryImpl.getRepository();
        room = RoomFactory.getRoom("10", "Meeting");
    }

    @Test
    public void getRepository() {
        assertNotNull(repository);
        System.out.println(repository);
    }

    @Test
    public void getAll() {
        repository.create(room);
        assertNotNull(repository.getAll());
        System.out.println("Get All\n" + repository.getAll());
    }

    @Test
    public void create() {
        repository.create(room);
        assertNotNull(repository.read(room.getRoomNumber()));
        System.out.println("Created\n" + repository.read(room.getRoomNumber()));
    }

    @Test
    public void read() {

        repository.create(room);

        Room rooms = repository.read(room.getRoomNumber());

        assertEquals(room, rooms);
    }

    @Test
    public void update() {

        repository.create(room);

        Room updatedRoom = RoomFactory.getRoom("10",  "Bathroom");

        repository.update(updatedRoom);

        Assert.assertNotEquals(room.getRoomType(), updatedRoom.getRoomType());
    }

    @Test
    public void delete() {
        repository.delete("11");
        assertNull(repository.read("11"));
        System.out.println("Deleted\n" + repository.read("11"));
    }

}