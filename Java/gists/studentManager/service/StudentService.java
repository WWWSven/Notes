package com.itheima.studentManager.service;

import com.itheima.studentManager.dao.StudentDao;
import com.itheima.studentManager.dao.dao;
import com.itheima.studentManager.domain.Person;
import com.itheima.studentManager.util.getDaoInstance;

import java.util.Collection;

public class StudentService implements service{
    // StudentDao studentDao = new StudentDao();
    dao studentDao = getDaoInstance.getInstance("studentDao");
    public boolean add(Person person) {
        if (studentDao.getIndex(person.getId())>-1) return false;
        boolean add = studentDao.add(person);
        return add;
    }

    @Override
    public boolean delete(int id) {
        if (studentDao.getIndex(id)<-1) return false;
        boolean delete = studentDao.delete(id);
        return delete;
    }

    @Override
    public boolean update(Person person) {
        boolean update = studentDao.update(person);
        return update;
    }

    @Override
    public Collection getAll() {
        Collection all = studentDao.getAll();
        return all;
    }

    @Override
    public boolean isExist(int id) {
        int index = studentDao.getIndex(id);
        return index > -1;
    }

    @Override
    public boolean saveInDB() {
        this.studentDao.store();
        return true;
    }
}
