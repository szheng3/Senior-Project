package com.springTeam55UCI.mvc.com.util;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

/**
 * Created by Leo on 2/3/2017.
 */
public class CheckTable {
    public static int CheckTable(Connection conn, String username) {
        System.out.println("username passed to CheckTable: "+username);
        int last_id = 0;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, "OUTPUT", null);
            if (tables.next()) {
                System.out.println("Table 'OUTPUT' exists. Tuple ready for upload.");
                Statement stmt0 = conn.createStatement();
                String sql0 = "SELECT MAX(ID) AS ID FROM OUTPUT WHERE user='"+username+"'";
                ResultSet rs = stmt0.executeQuery(sql0);
                if(rs.next()) {
                    last_id = rs.getInt("ID");
                    System.out.println("last gen ID is " + last_id);
                }
            } else {
                System.out.println("Table 'OUTPUT' DNE, creating table...");
                Statement stmt = conn.createStatement();
                String sqltb =  "CREATE TABLE OUTPUT " +
                        "(user VARCHAR(50), " +
                        "id INTEGER NOT NULL AUTO_INCREMENT, " +
                        "outputfile LONGBLOB, " +
                        "addTime TIMESTAMP ) ";
                stmt.executeUpdate(sqltb);
                System.out.println("Table 'OUTPUT' Created.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return last_id;
    }
}