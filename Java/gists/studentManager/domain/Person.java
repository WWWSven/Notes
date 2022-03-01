package com.itheima.studentManager.domain;

public abstract class Person {
    private int id;
    private String name;

    public abstract Person buildData(String... strings);

    public Person() {
    }

    public Person(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id+","+this.name;
    }
}
