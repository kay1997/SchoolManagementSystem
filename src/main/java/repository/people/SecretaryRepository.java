package repository.people;

import domain.people.Secretary;
import repository.IRepository;

import java.util.Set;

public interface SecretaryRepository extends IRepository<Secretary, String> {

    Set<Secretary> getAll();

}