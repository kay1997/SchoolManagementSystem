package factory.people;

import domain.people.Educator;

public class EducatorFactory {

    public static Educator getEducator(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Educator.Builder().educatorIDNumber(id)
                .educatorFirstName(firstName)
                .educatorLastName(lastName)
                .educatorDateOfBirth(dateOfBirth)
                .educatorAddress(address)
                .educatorContactNumber(contactNumber)
                .educatorAge(age)
                .build();
    }
}
