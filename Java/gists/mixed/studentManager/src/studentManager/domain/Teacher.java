package studentManager.domain;

public class Teacher extends Person{
    private String teachCourse;

    @Override
    public Person buildData(String... strings) {
        return new Teacher(Integer.parseInt(strings[0]),strings[1],strings[2]);
    }

    public Teacher(){}
    public Teacher(int id, String name, String teachCourse) {
        super(id, name);
        this.teachCourse = teachCourse;
    }
    public String getTeachCourse() {
        return teachCourse;
    }
    public void setTeachCourse(String teachCourse) {
        this.teachCourse = teachCourse;
    }

    @Override
    public String toString() {
        return super.toString()+","+this.teachCourse;
    }
}
