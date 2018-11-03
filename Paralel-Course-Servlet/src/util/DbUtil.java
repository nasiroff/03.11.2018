package util;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DbUtil {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/course-step");
            connection = dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeAll(AutoCloseable... closeables){
        for (AutoCloseable autoCloseable : closeables){
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
