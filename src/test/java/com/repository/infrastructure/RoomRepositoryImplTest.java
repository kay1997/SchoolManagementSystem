package com.repository.infrastructure;

import com.app.SchoolManagementSystemApplication;
import com.domain.infrastructure.Room;
import com.factory.infrastructure.RoomFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = SchoolManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class RoomRepositoryImplTest {
    @Autowired
    private RoomRepository repository;
    private String roomNo = null;

    @Test
    public void CreateRoomTest() throws IOException {
        Room room = RoomFactory.getRoom("22");
        Room result = repository.create(room);
        roomNo = result.getRoomNumber();
        Assert.assertNotNull(room);
    }

    @Test
    public void GetRoomTest() throws IOException {

        Room room = repository.read(roomNo);
        Assert.assertNotNull(room);
    }
}
