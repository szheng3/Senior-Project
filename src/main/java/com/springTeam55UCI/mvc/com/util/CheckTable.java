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
    public static void CheckTable(Connection conn) {

        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, "OUTPUT", null);
            if (tables.next()) {
                System.out.println("Table 'OUTPUT' exists. Tuple ready for upload.");
                //do nothing
            } else {
                System.out.println("Table 'OUTPUT' DNE, creating table...");
                Statement stmt = conn.createStatement();
                String sqltb =  "CREATE TABLE OUTPUT " +
                                "(id INTEGER NOT NULL, " +
                                "outputfile LONGBLOB, " +
                                "PRIMARY KEY ( id ))";
                stmt.executeUpdate(sqltb);
                System.out.println("Table 'OUTPUT' Created.");
                String sqlvl =  "INSERT INTO OUTPUT(id, outputfile)" +
                                "VALUES (159, NULL)";
                stmt.executeUpdate(sqlvl);
                System.out.println("Tuple created, ready for upload.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
