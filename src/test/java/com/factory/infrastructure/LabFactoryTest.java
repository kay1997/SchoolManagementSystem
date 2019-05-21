package com.factory.infrastructure;

import org.junit.Assert;
import org.junit.Test;
import com.domain.infrastructure.Lab;

public class LabFactoryTest {

    @Test
    public void getExamPaperNumber() {

        String number = "2";
        String type = "Computer Lab";

        Lab lab = LabFactory.getLab(number, type);
        System.out.println(lab);
        Assert.assertNotNull(lab.getLabNumber());
    }
}
