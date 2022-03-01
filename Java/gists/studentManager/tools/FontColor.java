package com.itheima.studentManager.tools;

import java.util.ArrayList;

public class FontColor {
    // font
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // background
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static String Top(String top){
        return ANSI_WHITE_BACKGROUND+ANSI_RED+top+ANSI_RESET;
    }
    public static String Option(ArrayList<String> op){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < op.size(); i++) {
            sb.append(ANSI_RED+String.valueOf(i+1)+
                ANSI_BLACK+":"+ANSI_GREEN+op.get(i)+ANSI_RESET+"  ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        System.out.println(Option(a));
    }
}
