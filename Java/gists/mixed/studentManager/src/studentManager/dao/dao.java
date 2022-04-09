package studentManager.dao;

import studentManager.domain.Person;

import java.util.Collection;

public interface dao<T> {
    boolean add(Person person);
    boolean delete(int id);
    boolean update(Person person);
    Collection getAll();
    int getIndex(int id);
    boolean store();
}
