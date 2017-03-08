package com.springTeam55UCI.mvc.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Leo on 2/3/2017.
 */
public class WriteBlob {
    public static void writeBlob(Connection conn, String fileaddr, int last_id, String username) {
        System.out.println("username passed to WriteBlob: "+username);
        // update sql
            String updateSQL = "UPDATE OUTPUT "
                + "SET outputfile = ?, "
                + "addTime =  DATE_SUB(NOW(), INTERVAL 8 HOUR) "
                + "WHERE id=";
            String updateSQL1 = " AND user=";
        try {
            Statement stmt0 = conn.createStatement();
            last_id++;
//            String username2 = "'testuser1'";       //HARDCODE
            String username2 = "'" + username + "'";    //Adding single quote to String.
            String sqlvl0 = "INSERT INTO OUTPUT(user, id, outputfile, addTime) " +
                    "VALUES (";
            String sqlvl1 = ", NULL, DATE_SUB(NOW(), INTERVAL 8 HOUR))";
            stmt0.executeUpdate(sqlvl0 + username2 + ", " + last_id + sqlvl1);  //TEMP!!!!!CHANGE username2 TO username1
            System.out.println("Tuple incremented, ready for upload.");


            PreparedStatement psmt = conn.prepareStatement(updateSQL+last_id+updateSQL1+username2);  //TEMP!!!!!CHANGE username2 TO username1
            // read the file
            File file = new File(fileaddr);
            FileInputStream input = new FileInputStream(file);
            psmt.setBinaryStream(1, input);

            // store the file in database
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
