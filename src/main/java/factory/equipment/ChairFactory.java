package factory.equipment;


import domain.equipment.Chair;

public class ChairFactory {

    public static Chair getChair(String chairNumber) {
        return new Chair.Builder().chairNumber(chairNumber).build();
    }
}

