package com.springTeam55UCI.mvc.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Leo on 2/3/2017.
 */
public class WriteBlob {

    //TODO: ADD TIME STAMP

    public static void writeBlob(Connection conn, String fileaddr, int last_id) {
        // update sql
            String updateSQL = "UPDATE OUTPUT "
                + "SET outputfile = ? "
                + "WHERE id=";

        try {
            PreparedStatement psmt = conn.prepareStatement(updateSQL+last_id);
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
