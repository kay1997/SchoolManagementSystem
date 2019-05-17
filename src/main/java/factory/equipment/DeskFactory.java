package factory.equipment;

import domain.equipment.Desk;

public class DeskFactory {

    public static Desk getDesk(String deskNumber) {
        return new Desk.Builder().deskNumber(deskNumber).build();
    }
}