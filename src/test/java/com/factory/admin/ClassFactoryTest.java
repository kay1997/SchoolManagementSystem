package com.factory.admin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.domain.admin.Class;


public class ClassFactoryTest {

    Class cls;
    @Before
    public void setUp() throws Exception {
        cls = ClassFactory.getClass("123", "A");
    }

    @Test
    public void getClassGroup()
    {
        Assert.assertNotNull(cls);
        System.out.println(cls);

    }

}