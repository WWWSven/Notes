package com.itheima.studentManager.dao;

import com.itheima.studentManager.domain.Person;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class daoFactory<T extends Person> {
    protected ArrayList<T> list = new ArrayList<>();
    public boolean store(){ // 这是存储，，，写错名字了
        String name = this.getClass().getSimpleName();
        File file = new File(name);
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ){
            for (T t : this.list) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public daoFactory() {
        this.init();
    }
    public boolean init() {
        // 获得数据文件存储名字
        String name = this.getClass().getSimpleName();
        File file = new File(name);
        try {
            if (!file.exists()){
                boolean newFile = file.createNewFile();
                System.out.println(newFile?name+"数据库文件不存在，重新创建成功！"
                        :"数据库文件不存在，重新创建失败！");
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ){

            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] split = line.split(",");
                /// ~~
                T instance = getInstanceOfT();
                T dao = (T) instance.buildData(split);
                this.list.add(dao);
            }
            return true;
        }catch (Exception e){
            // no use
            e.printStackTrace();
        }
        return false;
    }
    T getInstanceOfT()
    {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
        try {
            return type.newInstance();
        } catch (Exception e) {
            // Oops, no default constructor
            throw new RuntimeException(e);
        }
    }
}
