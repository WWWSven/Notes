package mybatis.simpleStart;

import mybatis.entity.emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class run {
    public static void main(String[] args) throws IOException {
        InputStream mybatis = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(mybatis);
        SqlSession session = build.openSession();
        List<emp> list = session.selectList("selectAll");
        System.out.println(list.size());
    }

}
