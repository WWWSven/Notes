package mybatis.agentMapper;

import mybatis.agentMapper.mapper.empMapper;
import mybatis.entity.emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class run {
    public static void main(String[] args) throws IOException {
        InputStream mybatis = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(mybatis);
        SqlSession sqlSession = sessionFactory.openSession(true);
        // 接口用于获得全类名："mybatis.agentMapper.mapper.empMapper"
        empMapper mapper = sqlSession.getMapper(empMapper.class);

        // List<emp> emps = mapper.selectAll();
        // emps.stream().forEach(System.out::println);

        // emp emp = mapper.selectOneById(7698);
        // System.out.println(emp);

        // mapper.selectOneByJobAndSal("经理", 1000).forEach(System.out::println);
        // System.out.println(mapper.selectOneByParam(null, "blake", null));
        // mapper.selectByParam(null, "%c%", null).forEach(System.out::println);
        // empFoo empFoo = new empFoo(null,"fuck1",null);
        // System.out.println(mapper.selectOneByEmpFooObj(empFoo));
        // System.out.println(mapper.selectOneByEmpFooObj(new empFoo(null, null, null)));

        // update,set
        /*
        empFoo foo = new empFoo(7936, "foo", "bar");
        System.out.println(mapper.updateById(foo));
        System.out.println(foo.id);
        */

        // insert
        /*
        empFoo foo = new empFoo(null, "bar", "bar");
        System.out.println(mapper.insertOne(foo));
        System.out.println(foo.id);
        */

        ArrayList<emp> list = new ArrayList<>();
        list.add(new emp(null,"foo01","j1","1",null,null,null,null));
        list.add(new emp(null,"foo02","j2","2",null,null,null,null));
        list.add(new emp(null,"foo03","j3","3",null,null,null,null));
        list.add(new emp(null,"foo04","j4","4",null,null,null,null));
        list.add(new emp(null,"foo05","j5","5",null,null,null,null));
        mapper.insertList(list);
    }
}
