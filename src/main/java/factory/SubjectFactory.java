package factory;

import domain.Subject;
public class SubjectFactory {

    public static Subject getSubject(String subjectCode, String subjectName) {
        return new Subject.Builder().subjectCode(subjectCode).subjectName(subjectName).build();
    }
}
