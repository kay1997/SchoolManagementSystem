package factory;

import domain.Desk;

public class DeskFactory {

    public static Desk getDesk(String deskNumber) {
        return new Desk.Builder().deskNumber(deskNumber).build();
    }
}