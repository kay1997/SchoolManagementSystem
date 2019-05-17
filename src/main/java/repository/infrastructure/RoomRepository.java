package repository.infrastructure;

import domain.infrastructure.Room;
import repository.IRepository;

import java.util.Set;

public interface RoomRepository extends IRepository<Room, String> {

    Set<Room> getAll();

}