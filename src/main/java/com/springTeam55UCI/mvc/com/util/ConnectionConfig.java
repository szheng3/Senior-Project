package com.springTeam55UCI.mvc.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Leo on 1/21/2017.
 */
public class ConnectionConfig {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3162493","sql3162493","rCeyV17JAN");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(connection==null);
        return connection;
    }
}
