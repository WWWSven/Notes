package com.itheima.studentManager.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.itheima.studentManager.domain.Student;
import com.itheima.studentManager.domain.Teacher;
import com.itheima.studentManager.service.StudentService;
import com.itheima.studentManager.tools.FontColor;


public class StudentController {
    protected Scanner scanner;
    public StudentController(Scanner scanner){
        this.scanner=scanner;
    }

    private StudentService ss =  new StudentService();

    public void addStudent(){
        while (true){
            System.out.print("输入学生id：");
            int id = scanner.nextInt();
            if (ss.isExist(id)){
                System.out.println("id已经存在，重新输入！");
                continue;
            }
            System.out.print("输入姓名：");
            String name = scanner.next();
            Student student = new Student(id, name);
            boolean add = ss.add(student);
            if (add) System.out.println("添加成功！");
            else System.out.println("添加失败！");
            break;
        }
    }
    public void getStudents(){
        ArrayList<Student> students = (ArrayList<Student>) ss.getAll();
        if (students.size()==0) {
            System.out.println("没有信息，请添加！");
            return;
        }
        for (Student sItem: students) {
            System.out.printf("ID: %d \t \tNAME: %s \n", sItem.getId(), sItem.getName());
        }
    }
    public void deleteStudent(){
        if (ss.getAll().size()!=0) getStudents();
        else {
            System.out.println("一个学生都没有，先添加！");
            return;
        }
        System.out.print("输入需要删除学生的id：");
        boolean b = ss.delete(scanner.nextInt());
        if (b){
            System.out.println("删除成功！");
        }else{
            System.out.println("不存在这个学生！");
        }
    }
    public void editStudent(){
        if (ss.getAll().size()==0){
            System.out.println("一个学生都没有，先添加！");
            return;
        }
        while (true) {
            System.out.print("输入要修改的学生id：");
            int id = scanner.nextInt();
            if (!ss.isExist(id)) {
                System.out.println("学生不存在！");
            } else {
                System.out.printf("输入%d的学生姓名(退出修改输入over)：", id);
                String name = scanner.next();
                if ("over".equals(name)) {
                    return;
                }
                boolean b = ss.update(new Student(id,name));
                if (b) {
                    System.out.println("修改成功！");
                } else {
                    System.out.println("修改失败！");
                }
                return;
            }
        }
    }


    public void start(){
        while (true){
            System.out.println(FontColor.Top("-------------------------- 欢迎来到学生管理系统 --------------------------"));
            ArrayList<String> option = new ArrayList<>();
            option.add("添加学生");option.add("删除学生");option.add("修改学生");option.add("查看学生");option.add("退出学生管理系统");
            System.out.println(FontColor.Option(option));
            switch (scanner.nextInt()){
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    getStudents();
                    break;
                case 5:
                    ss.saveInDB();
                    return;
            }
        }
    }
}
