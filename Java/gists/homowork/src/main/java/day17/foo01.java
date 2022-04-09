package day17;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;

interface fruit{
    public abstract void zha();
}
class apple implements fruit{
    @Override
    public void zha() {
        System.out.println("苹果榨汁！");
    }
}
class banana implements fruit{
    @Override
    public void zha() {
        System.out.println("香蕉榨汁！");
    }
}
public class foo01{
    public static void main(String[] args) {
        try {
            // 获取xml配置文件
            ClassLoader classLoader = foo01.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("config.xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            Element rootElement = document.getRootElement();
            Element fruit = rootElement.element("fruit");
            String zhaFullClassName = fruit.attribute("zha").getValue();
            //~~
            Class aClass = Class.forName(zhaFullClassName);
            Constructor constructor = aClass.getDeclaredConstructor();
            fruit o = (fruit) constructor.newInstance();
            zha(o);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void zha(fruit f){
        f.zha();
    }
}

