package com.factory.people;

import com.domain.people.Secretary;

public class SecretaryFactory {

    public static Secretary getSecretary(String id, String firstName, String lastName, String dateOfBirth, String address, String contactNumber, int age) {
        return new Secretary.Builder().secretaryIDNumber(id)
                .secretaryFirstName(firstName)
                .secretaryLastName(lastName)
                .secretaryAddress(address)
                .secretaryDateOfBirth(dateOfBirth)
                .secretaryContactNumber(contactNumber)
                .secretaryAge(age)
                .build();
    }
}
