package factory;

import domain.Computer;

public class ComputerFactory {

    public static Computer getComputer(String computerNumber, String computerName) {
        return new Computer.Builder().computerNumber(computerNumber)
                .computerName(computerName)
                .build();
    }
}
