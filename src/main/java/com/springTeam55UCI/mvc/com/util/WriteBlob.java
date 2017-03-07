package com.springTeam55UCI.mvc.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Leo on 2/3/2017.
 */
public class WriteBlob {
    public static void writeBlob(Connection conn, String fileaddr, int last_id, String username) {
        System.out.println("username passed to CheckTable: "+username);
        // update sql
            String updateSQL = "UPDATE OUTPUT "
                + "SET outputfile = ?, "
                + "addTime =  DATE_SUB(NOW(), INTERVAL 8 HOUR) "
                + "WHERE id=";
            String updateSQL1 = " AND user=";
        try {
            Statement stmt0 = conn.createStatement();
            last_id++;
            String sqlvl0 = "INSERT INTO OUTPUT(user, id, outputfile, addTime)" +
                    "VALUES (";
            String sqlvl1 = ", NULL, DATE_SUB(NOW(), INTERVAL 8 HOUR))";
            stmt0.executeUpdate(sqlvl0 + username + ", " + last_id + sqlvl1);
            System.out.println("Tuple incremented, ready for upload.");


            PreparedStatement psmt = conn.prepareStatement(updateSQL+last_id+updateSQL1+username);
            // read the file
            File file = new File(fileaddr);
            FileInputStream input = new FileInputStream(file);
            psmt.setBinaryStream(1, input);

            // store the resume file in database
            System.out.println("Reading file " + file.getAbsolutePath());
            System.out.println("Storing file into the database.");
            psmt.executeUpdate();

            System.out.println("File successfully stored to DB.");
            psmt.close();

        }   catch (SQLException se) {
            se.printStackTrace();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
