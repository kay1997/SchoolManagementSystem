package factory.people;

import domain.people.Principle;

public class PrincipleFactory {

    public static Principle getPrinciple(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Principle.Builder().principleIDNumber(id)
                .principleFirstName(firstName)
                .principleLastName(lastName)
                .principleDateOfBirth(dateOfBirth)
                .principleAddress(address)
                .principleContactNumber(contactNumber)
                .principleAge(age)
                .build();
    }
}