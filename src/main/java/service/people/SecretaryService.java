package service.people;

import domain.people.Secretary;
import service.IService;

import java.util.Set;

public interface SecretaryService  extends IService<Secretary, String> {

    Set<Secretary> getAll();

}

