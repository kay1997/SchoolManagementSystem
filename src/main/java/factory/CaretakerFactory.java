package factory;

import domain.Caretaker;

public class CaretakerFactory {

    public static Caretaker getCaretaker(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Caretaker.Builder().caretakerIDNumber(id)
                .caretakerFirstName(firstName)
                .caretakerLastName(lastName)
                .caretakerAddress(address)
                .caretakerDateOfBirth(dateOfBirth)
                .caretakerContactNumber(contactNumber)
                .caretakerAge(age)
                .build();
    }
}

