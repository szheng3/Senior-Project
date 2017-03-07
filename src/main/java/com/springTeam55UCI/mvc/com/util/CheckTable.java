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
    public static int CheckTable(Connection conn, boolean CheckOnly, String username) {

        int last_id = 1;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, "OUTPUT", null);
            if (tables.next()) {
                System.out.println("Table 'OUTPUT' exists. Tuple ready for upload.");
                Statement stmt0 = conn.createStatement();
                ResultSet rs = stmt0.executeQuery("SELECT MAX(ID) AS ID FROM OUTPUT");
                if(rs.next()) {
                    last_id = rs.getInt("ID");
                    System.out.println("last gen ID is " + last_id);
                }
                if(!CheckOnly) {
                    last_id++;
                    String sqlvl0 = "INSERT INTO OUTPUT(id, outputfile, addTime, user)" +
                            "VALUES (";
                    String sqlvl1 = ", NULL, DATE_SUB(NOW(), INTERVAL 8 HOUR), ";
                    stmt0.executeUpdate(sqlvl0 + last_id + sqlvl1 + username + ")");
                    System.out.println("Tuple incremented, ready for upload.");
                }
                else {
                    System.out.println("Only checking size, tuple not incremented.");
                }
            } else {
                System.out.println("Table 'OUTPUT' DNE, creating table...");
                Statement stmt = conn.createStatement();
                String sqltb =  "CREATE TABLE OUTPUT " +
                        "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                        "outputfile LONGBLOB, " +
                        "addTime TIMESTAMP, " +
                        "user VARCHAR(50), " +
                        "PRIMARY KEY ( id ))";
                stmt.executeUpdate(sqltb);
                System.out.println("Table 'OUTPUT' Created.");
                String sqlvl =  "INSERT INTO OUTPUT(id, outputfile, addTime, user)" +
                        "VALUES (1, NULL, DATE_SUB(NOW(), INTERVAL 8 HOUR), ";
                stmt.executeUpdate(sqlvl+username+")");
                System.out.println("Tuple created, ready for upload.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return last_id;
    }
}