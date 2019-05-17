package service.people;

import domain.people.Security;
import service.IService;

import java.util.Set;

public interface SecurityService   extends IService<Security, String> {

    Set<Security> getAll();

}