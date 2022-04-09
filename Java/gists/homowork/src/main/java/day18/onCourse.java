package day18;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import java.io.*;
import java.util.*;

public class onCourse {
    @test("sssss")
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        System.out.println("a" + "b");

    }
}
@interface test{
    // String value();
    String value();
}
class processor extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}


class jUnit{
    public int add(int a, int b){
        return a+b;
    }

    @Test
    public void testAdd(){
        int add = add(1, 2);
        assert 3==add;
    }

    @Test
    public void testTypeKind(){
        TypeKind t = TypeKind.valueOf("INT");
        System.out.println(t);
    }
}

class log4j2{
    public static void main(String[] args) {
        Logger l = LogManager.getLogger(log4j2.class);
        Level level = l.getLevel();
        System.out.println(level.name());
        System.out.println(l.getName());
        l.printf(Level.ERROR,"------------------------------------");
        l.debug("debug");
        l.info("info");
        l.error("error");

        // Logger logger = LoggerFactory.getLogger(log4j.class);
    }
}

class t{
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0)-o1.charAt(0);
            }
        });
        String[] s ={"hello","world","java","world"};
        Collections.addAll(ts,s);
        System.out.println(ts);
    }
}




class test02{
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("stu.txt", true));
        bufferedWriter.flush();
    }
}


























