package com.springTeam55UCI.mvc;

import javax.servlet.http.HttpServlet;

/**
 * Created by Leo on 2/20/2017.
 */
public class ViewHistoryHandler extends HttpServlet {
//    @Override
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//
//        Connection connection = null;
//        String username = (String)request.getSession().getAttribute("username");
//        String username0 = "shuaizheng";   //TEMP!!!!! delete
//        System.out.println("username passed to ViewHistoryHandler: "+username0);    //TEMP!!!!! change username0 to username
//        try {
//            connection = ConnectionConfig.getConnection();
//            if(connection != null) {
//                System.out.println("Connection established.");
//                int last_id = CheckTable(connection, username0);    //TEMP!!!!! change username0 to username
//                System.out.println("last id is: "+last_id);     //Debug PRINTF
//                request.setAttribute("last_id", last_id);
//                request.getSession().setMaxInactiveInterval(1440);
//                String saveLocation = request.getSession().getServletContext().getRealPath("") + File.separator + "output";
//                System.out.println("The location to save to is: "+saveLocation);     //Debug PRINTF
//                for(int i=1;i<=last_id;i++) {
//                    String sql = "SELECT outputfile FROM OUTPUT WHERE id=? AND USER=?";
//
//                    String username2 = username0;
//                    String username1 = username;
//                    PreparedStatement stmt = connection.prepareStatement(sql);
//                    stmt.setInt(1,i);
//                    stmt.setString(2,username2);    //TEMP!!!!! change username2 to username1
//
//                    ResultSet result =stmt.executeQuery();
//                    if(result.next()) {
//                        Blob blob = result.getBlob("outputfile");
//                        InputStream inputstream = blob.getBinaryStream();
//                        OutputStream outputstream = new FileOutputStream(saveLocation + i + ".txt");
//
//                        int bytesRead = -1;
//                        byte[] buffer = new byte[4096];
//                        while ((bytesRead = inputstream.read(buffer)) != -1) {
//                            outputstream.write(buffer, 0, bytesRead);
//                        }
//                        inputstream.close();
//                        outputstream.close();
//                        System.out.println("File " + i + " stored locally");
//                    }
//                }
//                connection.close();
//            }
//            else {
//                System.out.println("Connection failed.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        request.getRequestDispatcher("/WEB-INF/pages/history.jsp").forward(request, response);
//    }
}
