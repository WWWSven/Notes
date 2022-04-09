package mybatis.entity;

public class empFoo {
    public Integer id;
    public String name;
    public String job;

    @Override
    public String toString() {
        return "empFoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public empFoo(Integer id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }
}
