package com.factory.admin;

import org.junit.Assert;
import org.junit.Test;
import com.domain.admin.Class;


public class ClassFactorytTest {

    @Test
    public void getClassGroup() {

        String group = "A";

        Class cls = ClassFactory.getClass(group);
        System.out.println(cls);
        Assert.assertNotNull(cls.getClassGroup());
    }
}
