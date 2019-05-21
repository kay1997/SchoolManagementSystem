package com.factory.admin;

import org.junit.Assert;
import org.junit.Test;
import com.domain.admin.School;


public class SchoolFactoryTest {

    @Test
    public void getSchoolName() {

        String code = "S03";
        String name = "Westridge High";
        String address = "Cape Town";
        String phoneNumber = "0211344567";

        School school = SchoolFactory.getSchool(code, name, address, phoneNumber);
        System.out.println(school);
        Assert.assertNotNull(school.getSchoolName());
    }
}
