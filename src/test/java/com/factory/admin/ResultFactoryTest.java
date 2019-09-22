package com.factory.admin;

import org.junit.Assert;
import org.junit.Test;
import com.domain.admin.Result;

public class ResultFactoryTest {

    @Test
    public void getSubjectMark() {

        String learnerID = "9708265184084";
        String mark = "89";

        Result result = ResultFactory.getResult(learnerID, mark);
        System.out.println(result);
        Assert.assertNotNull(result.getSubjectMark());
    }
}
