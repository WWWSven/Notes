package studentManager.domain;

public class Student extends Person{
    @Override
    public Person buildData(String... strings) {
        return new Student(Integer.parseInt(strings[0]),strings[1]);
    }

    public Student(){}

    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
