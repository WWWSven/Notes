package jdbcReflectGeneric;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;

public class DBUtil<T>{
    private static Connection connection = jdbcConnectUtil.getConnection();
    String name; //table name
    String primaryKey;

    public DBUtil() {
        name = this.getGenericClass().getSimpleName();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from "+name;
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            primaryKey = metaData.getColumnLabel(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(T t){
        Integer max = null;
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select max(" + primaryKey + ") from " + name);
            resultSet.next();
            max = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "insert into "+name+" values("+(max+1)+",?,?,?,?,?,?,?)";
        Class<T> tClass = (Class<T>) t.getClass();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Field[] fields = tClass.getFields();
            for (int i = 1; i < fields.length; i++) {
                Object o = tClass.getField(fields[i].getName()).get(t);
                preparedStatement.setObject(i,o);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void updateById(Integer id,String key,String value){
        String sql = String.format("update %s set %s=? where %s=?",
                    name,key,primaryKey
                );
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value);
            preparedStatement.setInt(2,id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteById(Integer id){
        String sql = "delete from "+name+" where "+primaryKey+"=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<T> fetchAll(){
        String sql = "select * from "+name;
        ArrayList<T> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Class<T> genericClass = getGenericClass();
                T t = genericClass.newInstance();
                Field[] fields = genericClass.getFields();
                for (Field field : fields) {
                    field.set(t, resultSet.getObject(field.getName()));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public T fetchById(Integer id){
        String sql = "select * from " + name + " where " + primaryKey + "=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Class<T> genericClass = getGenericClass();
            T instance = genericClass.newInstance();
            Field[] fields = genericClass.getFields();
            while (resultSet.next()){
                for (Field field : fields) {
                    Object o = resultSet.getObject(field.getName());
                    // System.out.println(name+":::"+field.getType().getSimpleName()+"::"+o);
                    field.set(instance,o);
                }
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class<T> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}

class emp extends DBUtil<emp>{
    public Integer empno;
    public String ename;
    public String job;
    public Integer mgr;
    public Date hiredate;
    public Double sal;
    public Double comm;
    public Integer deptno;
    @Override
    public String toString() {
        return "emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate='" + hiredate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                "} ";
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        emp emp = new emp();
        /*System.out.println("# Test select by id");
        System.out.println(emp.fetchById(7369));
        System.out.println("# Test select all data");
        emp.fetchAll().stream().forEach(emp1 -> System.out.println(emp1));*/
        // System.out.println("# Test Delete by id");
        // emp.deleteById(emp.fetchAll().get(0).empno);
        // emp.updateById(emp.fetchAll().get(0).empno, "job","job1");
        jdbcReflectGeneric.emp emp1 = new emp();
        emp1.ename="fuck1";
        emp.insert(emp1);
    }

}
