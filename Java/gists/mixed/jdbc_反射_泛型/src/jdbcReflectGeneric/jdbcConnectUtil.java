package jdbcReflectGeneric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class jdbcConnectUtil {
    public static Connection getConnection(){
        try {
            String connect = getConfig("connect");
            String username = getConfig("username");
            String password = getConfig("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connect,username,password);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static String getConfig(String key){
        String prefix = "jdbcReflectGeneric";
        ResourceBundle rb = ResourceBundle.getBundle("jdbcReflectGeneric");
        return rb.getString(prefix + '.' + key);
    }
}
