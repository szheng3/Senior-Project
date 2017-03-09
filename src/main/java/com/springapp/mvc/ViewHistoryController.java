package com.springapp.mvc;

import com.springTeam55UCI.mvc.com.util.ConnectionConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import java.sql.*;

import static com.springTeam55UCI.mvc.com.util.CheckTable.CheckTable;

/**
 * Created by Shuai Zheng on 3/8/17.
 */
@Controller
public class ViewHistoryController {
    @RequestMapping(value = "/viewhistory/{objectId}", method = RequestMethod.GET)
    public
    @ResponseBody
    void generateReport(
            @PathVariable("objectId") String objectId,
            HttpServletRequest request,
            HttpServletResponse response) {
        Connection connection = null;
        String username = (String) request.getSession().getAttribute("username");
        String username0 = objectId;   //TEMP!!!!! delete
        System.out.println("username passed to ViewHistoryHandler: " + username0);    //TEMP!!!!! change username0 to username
        try {
            connection = ConnectionConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established.");
                int last_id = CheckTable(connection, username0);    //TEMP!!!!! change username0 to username
                System.out.println("last id is: " + last_id);     //Debug PRINTF
                request.setAttribute("last_id", last_id);
                request.setAttribute("username", objectId);

                request.getSession().setMaxInactiveInterval(1440);
                String saveLocation = request.getSession().getServletContext().getRealPath("") + File.separator + "output";
                System.out.println("The location to save to is: " + saveLocation);     //Debug PRINTF
                for (int i = 1; i <= last_id; i++) {
                    String sql = "SELECT addTime, outputfile FROM OUTPUT WHERE id=? AND USER=?";

                    String username2 = username0;
                    String username1 = username;
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setInt(1, i);
                    stmt.setString(2, username2);    //TEMP!!!!! change username2 to username1

                    ResultSet result = stmt.executeQuery();
                    if (result.next()) {
                        Timestamp addedTime = result.getTimestamp("addTime");
                        System.out.println("file num "+i+" has addTime: "+addedTime);
                        Blob blob = result.getBlob("outputfile");
                        InputStream inputstream = blob.getBinaryStream();
                        OutputStream outputstream = new FileOutputStream(saveLocation + i + ".txt");

                        int bytesRead = -1;
                        byte[] buffer = new byte[4096];
                        while ((bytesRead = inputstream.read(buffer)) != -1) {
                            outputstream.write(buffer, 0, bytesRead);
                        }
                        inputstream.close();
                        outputstream.close();

                        OutputStream outputstream1 = new FileOutputStream(saveLocation + i + "_time.txt");
                        PrintStream printStream1 = new PrintStream(outputstream1);
                        printStream1.print("Result BLOB Upload Time: "+addedTime);
                        printStream1.close();
                        outputstream1.close();

                        System.out.println("File " + i + " stored locally");
                    }
                }
                connection.close();
            } else {
                System.out.println("Connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/history.jsp").forward(request, response);


    }
}
