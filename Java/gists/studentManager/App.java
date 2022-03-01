package com.itheima.studentManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.itheima.studentManager.controller.*;
import com.itheima.studentManager.tools.FontColor;

public class App {
    public static void main(String[] args){
        while (true){
            try{
                menuRun();
            }catch (InputMismatchException ime){
                System.out.println("请正确输入：id是数字哦，菜单也是数字哦！");
            }
        }
    }

    private static void menuRun() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(FontColor.Top("-------------------------- welcome --------------------------"));
            ArrayList<String> option = new ArrayList<>();
            option.add("学生管理");option.add("教师管理");option.add("退出系统");
            System.out.println(FontColor.Option(option));
            switch (scanner.nextInt()){
                case 1:
                    new StudentController(scanner).start();
                    break;
                case 2:
                    new TeacherController(scanner).start();
                    break;
                case 3:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                    break;
            }
        }
    }
}
