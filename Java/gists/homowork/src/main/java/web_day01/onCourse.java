package web_day01;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class onCourse {
    @Test
    public void druidZSWfix(){
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(new Properties());
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void druid() throws Exception{
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        Connection connection = druidDataSource.getConnection("root", "password");
    }
    @Test
    public void foo() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaEE?useSSL=false", "root", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from emp");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()){
            String label;
            for (int i = 0; i < columnCount; i++) {
                label = metaData.getColumnLabel(i + 1);
                System.out.println(label+":"+resultSet.getString(label));
            }
            System.out.println("-----------------------------");
        }
    }
    @Test
    public void sqlIn() throws Exception {
        String connectStr = "jdbc:mysql://localhost:3306/javaEE?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectStr, "root", "password");
        Statement statement = connection.createStatement();
        String para = "7369";
        String para2 = "1 or 1=1";
        ResultSet resultSet = statement.executeQuery("select * from emp where empno="+para2);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
    }
    @Test
    public void fixSqlIn() throws Exception{
        String connectStr = "jdbc:mysql://localhost:3306/javaEE?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectStr, "root", "password");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empno=?");
        // preparedStatement.setString(1,"7369");
        preparedStatement.setString(1,"1 or 1=1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
    }
}
