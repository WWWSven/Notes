package studentManager.dao;

import studentManager.domain.Person;
import studentManager.domain.Student;

import java.util.ArrayList;
import java.util.Collection;

public class StudentDao extends daoFactory<Student> implements dao{
    ArrayList<Student> students = this.list;

    @Override
    public boolean add(Person person) {
        boolean add = students.add((Student) person);
        return add;
    }

    @Override
    public boolean delete(int id) {
        boolean removeIf = students.removeIf(student -> student.getId() == id);
        return removeIf;
    }

    @Override
    public boolean update(Person person) {
        int index = getIndex(person.getId());
        if (index<0) return false;
        students.set(index, (Student) person);
        return true;
    }

    @Override
    public Collection getAll() {
        return students;
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = null;
        for (Student student : students) {
            result += student.toString();
        }
        return result;
    }
}
