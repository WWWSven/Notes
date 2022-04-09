package studentManager.service;


import studentManager.dao.dao;
import studentManager.domain.Person;
import studentManager.util.getDaoInstance;

import java.util.Collection;

public class TeacherService implements service{
    // TeacherDao teacherDao = new TeacherDao();
    dao teacherDao = getDaoInstance.getInstance("teacherDao");
    public boolean add(Person person) {
        if (teacherDao.getIndex(person.getId())>-1) return false;
        boolean add = teacherDao.add(person);
        return add;
    }

    @Override
    public boolean delete(int id) {
        if (teacherDao.getIndex(id)<-1) return false;
        boolean delete = teacherDao.delete(id);
        return delete;
    }

    @Override
    public boolean update(Person person) {
        boolean update = teacherDao.update(person);
        return update;
    }

    @Override
    public Collection getAll() {
        Collection all = teacherDao.getAll();
        return all;
    }

    @Override
    public boolean isExist(int id) {
        int index = teacherDao.getIndex(id);
        return index > -1;
    }

    @Override
    public boolean saveInDB() {
        this.teacherDao.store();
        return true;
    }
}
