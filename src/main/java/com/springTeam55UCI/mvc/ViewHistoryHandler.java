package com.springTeam55UCI.mvc;

import com.springTeam55UCI.mvc.com.util.ConnectionConfig;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

import static com.springTeam55UCI.mvc.com.util.CheckTable.CheckTable;
import static com.springTeam55UCI.mvc.com.util.WriteBlob.writeBlob;

/**
 * Created by Leo on 2/20/2017.
 */
public class ViewHistoryHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Connection connection = null;
        String username = request.getParameter("username");     //BUGGED, (RETURN NULL)
        try {
            connection = ConnectionConfig.getConnection();
            if(connection != null) {
                System.out.println("Connection established.");
                System.out.println("user logged in is: "+username); //DEBUG PRINTF
                int last_id = CheckTable(connection, true, username);
                System.out.println("last id is: "+last_id);     //Debug PRINTF
                request.setAttribute("last_id", last_id);
                request.getSession().setMaxInactiveInterval(1440);
                String saveLocation = request.getSession().getServletContext().getRealPath("") + File.separator + "output";
                System.out.println("The location to save to is: "+saveLocation);     //Debug PRINTF
                for(int i=1;i<=last_id;i++) {
                    String sql = "SELECT outputfile FROM output WHERE id=? AND user = ";
                    PreparedStatement stmt = connection.prepareStatement(sql+username);
                    stmt.setInt(1,i);

                    ResultSet result =stmt.executeQuery();
                    if(result.next()) {
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
                        System.out.println("File " + i + " stored locally");
                    }
                }
                connection.close();
            }
            else {
                System.out.println("Connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
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
