package factory.people;

import domain.people.Caretaker;

public class CaretakerFactory {

    public static Caretaker getCaretaker(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Caretaker.Builder().caretakerIDNumber(id)
                .caretakerFirstName(firstName)
                .caretakerLastName(lastName)
                .caretakerDateOfBirth(dateOfBirth)
                .caretakerAddress(address)
                .caretakerContactNumber(contactNumber)
                .caretakerAge(age)
                .build();
    }
}

