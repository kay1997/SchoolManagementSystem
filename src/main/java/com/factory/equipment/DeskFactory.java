package com.factory.equipment;

import com.domain.equipment.Desk;

public class DeskFactory {

    public static Desk getDesk(String deskNumber, String deskType) {
        return new Desk.Builder().deskNumber(deskNumber).deskType(deskType).build();
    }
}