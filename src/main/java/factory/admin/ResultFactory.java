package factory.admin;

import domain.admin.Result;

public class ResultFactory {

    public static Result getResult(String subjectMark) {
        return new Result.Builder().subjectMark(subjectMark).build();
    }
}
