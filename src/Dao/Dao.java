package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao
{
    public static Connection getConnection()
            throws SQLException, ClassNotFoundException
    {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = null;
        con = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + "localhost"
                    + "/"
                    + "squat_schema"
                    + "?serverTimezone=JST",
                    "root",
                    "root"
                    );
        return con;
    }
}