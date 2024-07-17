package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
            + "qlbandt","root","root");
        } catch (ClassNotFoundException e){
            System.out.println("ClassNotFound "+e);
        } catch (SQLException e){
            System.out.println("SQLException "+e);
        }
        return c;
    }
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
