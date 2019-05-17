package factory.people;

import domain.people.Security;

public class SecurityFactory {

    public static Security getSecurity(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Security.Builder().securityIDNumber(id)
                .securityFirstName(firstName)
                .securityLastName(lastName)
                .securityAddress(address)
                .securityDateOfBirth(dateOfBirth)
                .securityContactNumber(contactNumber)
                .securityAge(age)
                .build();
    }
}

