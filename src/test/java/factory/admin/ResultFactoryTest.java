package factory.admin;

import factory.admin.ResultFactory;
import org.junit.Assert;
import org.junit.Test;
import domain.admin.Result;

public class ResultFactoryTest {

    @Test
    public void getSubjectMark() {

        String mark = "89";

        Result result = ResultFactory.getResult(mark);
        System.out.println(result);
        Assert.assertNotNull(result.getSubjectMark());
    }
}
