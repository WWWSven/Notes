package studentManager.service;


import studentManager.domain.Person;

import java.util.Collection;

public interface service {
    boolean add(Person person);
    boolean delete(int id);
    boolean update(Person person);
    Collection getAll();
    boolean isExist(int id);
    boolean saveInDB();
}
