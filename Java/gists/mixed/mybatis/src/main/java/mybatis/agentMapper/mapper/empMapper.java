package mybatis.agentMapper.mapper;

import mybatis.entity.emp;
import mybatis.entity.empFoo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface empMapper {
    List<emp> selectAll();
    emp selectOneById(Integer id);
    List<emp> selectOneByJobAndSal(@Param("job") String job,@Param("sal") Integer sal);
    List<emp> selectByParam(
            @Param("id") Integer id,
            @Param("name") String name,
            @Param("sal") String sal
    );
    emp selectOneByEmpFooObj(empFoo foo);
    // update
    /**
     * useGeneratedKeys	（仅适用于 insert 和 update）
     * 这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键
     */
    Integer updateById(empFoo foo);
    //Insert
    Integer insertOne(empFoo foo);
    //
    void insertList(@Param("empList") List<emp> list);

}
