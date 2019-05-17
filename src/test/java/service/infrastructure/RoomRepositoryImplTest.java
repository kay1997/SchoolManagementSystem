package service.infrastructure;

import domain.infrastructure.Room;
import factory.infrastructure.RoomFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.infrastructure.RoomRepository;
import repository.infrastructure.impl.RoomRepositoryImpl;

import java.util.Set;

import java.sql.SQLOutput;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {

    private RoomRepository repository;
    private Room room;

    private Room getSavedRoom() {
        Set<Room> savedRooms = this.repository.getAll();
        return savedRooms.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RoomRepositoryImpl.getRepository();
        this.room = RoomFactory.getRoom("3");
    }

    @Test
    public void a_create() {
        Room created = this.repository.create(this.room);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.room);
    }

    @Test
    public void b_read() {
        Room savedRoom = getSavedRoom();
        System.out.println("In read, room number = " + savedRoom.getRoomNumber());
        Room read = this.repository.read(savedRoom.getRoomNumber());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRoom, read);
    }

    @Test
    public void e_delete() {
        Room savedRoom = getSavedRoom();
        this.repository.delete(savedRoom.getRoomNumber());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newRoomNumber = "New Test Room Contact Number";
        Room room = new Room.Builder().copy(getSavedRoom()).roomNumber(newRoomNumber).build();
        System.out.println("In update, about_to_updated = " + room);
        Room updated = this.repository.update(room);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newRoomNumber, updated.getRoomNumber());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Room> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
