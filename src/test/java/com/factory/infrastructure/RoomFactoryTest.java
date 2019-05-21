package com.factory.infrastructure;

import org.junit.Assert;
import org.junit.Test;
import com.domain.infrastructure.Room;

public class RoomFactoryTest {

    @Test
    public void getRoomNumber() {

        String id = "2";

        Room room = RoomFactory.getRoom(id);
        System.out.println(room);
        Assert.assertNotNull(room.getRoomNumber());
    }
}
