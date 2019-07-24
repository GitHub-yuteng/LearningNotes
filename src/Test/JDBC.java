package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


/*
 create table student(
 	id int(4) primary key not null auto_increment,
 	name varchar(32) not null,
 	age varchar(32) not null,
 	birthday datetime not null,
);
 */
public class JDBC {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/emp";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql;
            sql = "INSERT INTO student values(?,?,?)";
            statement = conn.prepareStatement(sql);

            statement.setString(1, "a");
            statement.setInt(2, 20);
            Timestamp t = new Timestamp(new Date().getTime());
            statement.setTimestamp(3, t);
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
