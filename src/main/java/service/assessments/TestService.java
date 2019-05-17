package service.assessments;

import domain.assessments.Test;
import service.IService;

import java.util.Set;

public interface TestService extends IService<Test, String> {

    Set<Test> getAll();

}
