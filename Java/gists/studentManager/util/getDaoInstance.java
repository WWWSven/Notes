package com.itheima.studentManager.util;

import com.itheima.studentManager.dao.dao;
import com.itheima.studentManager.service.TeacherService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;

public class getDaoInstance {
    private static dao makeDao(String key){
        try {
            ClassLoader classLoader = TeacherService.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("config.xml");
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(in);
            Element rootElement = read.getRootElement();
            Element studentDao = rootElement.element(key);
            String className = studentDao.attribute("className").getValue();
            Class<dao> aClass = (Class<dao>) Class.forName(className);
            Constructor<dao> constructor = aClass.getDeclaredConstructor();
            dao daoIns = constructor.newInstance();
            return daoIns;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static dao getInstance(String key){
         return makeDao(key);
    }
}
