package com.factory.admin;

import com.domain.admin.Result;

public class ResultFactory {

    public static Result getResult(String learnerID, String subjectMark) {
        return new Result.Builder().learnerID(learnerID).subjectMark(subjectMark).build();
    }
}
