package factory.admin;

import domain.admin.School;

public class SchoolFactory {

    public static School getSchool(String schoolCode, String schoolName, String schoolAddress, String schoolContactNumber) {
        return new School.Builder().schoolCode(schoolCode)
                .schoolName(schoolName)
                .schoolAddress(schoolAddress)
                .schoolContactNumber(schoolContactNumber)
                .build();
    }
}
