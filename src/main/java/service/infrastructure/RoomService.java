package service.infrastructure;

import domain.infrastructure.Room;
import service.IService;

import java.util.Set;

public interface RoomService extends IService<Room, String> {

    Set<Room> getAll();

}
