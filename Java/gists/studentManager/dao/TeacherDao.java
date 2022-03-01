package com.itheima.studentManager.dao;

import com.itheima.studentManager.domain.Person;
import com.itheima.studentManager.domain.Student;
import com.itheima.studentManager.domain.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TeacherDao extends daoFactory<Teacher> implements dao{
    ArrayList<Teacher> teachers = this.list;

    @Override
    public boolean add(Person person) {
        boolean add = teachers.add((Teacher) person);
        return add;
    }

    @Override
    public boolean delete(int id) {
        boolean removeIf = teachers.removeIf(teacher -> teacher.getId() == id);
        return removeIf;
    }

    @Override
    public boolean update(Person person) {
        int index = getIndex(person.getId());
        if (index<0) return false;
        teachers.set(index, (Teacher) person);
        return true;
    }

    @Override
    public Collection getAll() {
        return teachers;
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()==id) return i;
        }
        return -1;
    }
    @Override
    public String toString() {
        String result = null;
        for (Teacher teacher : teachers) {
            result += teacher.toString();
        }
        return result;
    }
}
