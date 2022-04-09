package studentManager.controller;


import studentManager.domain.Teacher;
import studentManager.service.TeacherService;
import studentManager.tools.FontColor;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    protected Scanner scanner;
    public TeacherController(Scanner scanner){
        this.scanner=scanner;
    }

    private TeacherService ts =  new TeacherService();

    public void addTeacher(){
        while (true){
            System.out.print("输入职工号：");
            int id = scanner.nextInt();
            if (ts.isExist(id)){
                System.out.println("职工号已经存在，重新输入！");
                continue;
            }
            System.out.print("输入姓名：");
            String name = scanner.next();
            System.out.print("输入所授课目：");
            String course = scanner.next();
            Teacher teacher = new Teacher(id, name, course);
            boolean add = ts.add(teacher);
            if (add) System.out.println("添加成功！");
            else System.out.println("添加失败！");
            break;
        }
    }
    public void getTeachers(){
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) ts.getAll();
        if (teachers.size()==0) {
            System.out.println("没有信息，请添加！");
            return;
        }
        for (Teacher tItem: teachers) {
            System.out.printf("ID: %d \t \tNAME: %s\t \tteach Course is: %s \n",
                    tItem.getId(), tItem.getName(),tItem.getTeachCourse());
        }
    }
    public void deleteTeacher(){
        if (ts.getAll().size()!=0) getTeachers();
        else {
            System.out.println("一个老师都没有，先添加！");
            return;
        }
        System.out.print("输入需要删除老师的职工号：");
        boolean b = ts.delete(scanner.nextInt());
        if (b){
            System.out.println("删除成功！");
        }else{
            System.out.println("不存在这个老师！");
        }
    }
    public void updateTeacher() {
        if (ts.getAll().size() == 0) {
            System.out.println("一个老师都没有，先添加！");
            return;
        }
        while (true) {
            System.out.print("输入要修改的老师id：");
            int id = scanner.nextInt();
            if (!ts.isExist(id)) {
                System.out.println("老师不存在！");
            } else {
                System.out.printf("输入%d的老师姓名(退出修改输入over)：", id);
                String name = scanner.next();
                if ("over".equals(name)) {
                    return;
                }
                System.out.printf("输入%d的老师所授课目(退出修改输入over)：", id);
                String course = scanner.next();
                if ("over".equals(course)) {
                    return;
                }
                boolean b = ts.update(new Teacher(id,name,course));
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
            System.out.println(FontColor.Top("-------------------------- 欢迎来到老师管理系统 --------------------------"));
            ArrayList<String> option = new ArrayList<>();
            option.add("添加老师");option.add("删除老师");option.add("修改老师");option.add("查看老师");option.add("退出老师管理系统");
            System.out.println(FontColor.Option(option));
            switch (scanner.nextInt()){
                case 1:
                    addTeacher();
                    break;
                case 2:
                    deleteTeacher();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    getTeachers();
                    break;
                case 5:
                    ts.saveInDB();
                    return;
            }
        }
    }
}
