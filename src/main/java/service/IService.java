package service;

public interface IService<TYPE, ID> {
    TYPE create(TYPE t);
    TYPE update(TYPE t);
    void delete(ID id);
    TYPE read(ID id);
}
