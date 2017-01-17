package com.springTeam55UCI.mvc;

import EECS159.ShuaiZheng.Sort.Hw5Johnsons;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Shuai Zheng on 11/23/16.
 */
public class FileUploadHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        request.getSession().setMaxInactiveInterval(1440);
        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                response.setContentType("text/html");

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        item.write(new File(request.getSession().getServletContext().getRealPath("") + File.separator + new File(item.getName()).getName()));
                        ProOut Profile = new ProOut();
                        Profile.ProFileOutApplication(request.getSession().getServletContext().getRealPath(""), new File(item.getName()).getName());
//                        String[] args = new String[2];
//                        args[0] = "@" + request.getSession().getServletContext().getRealPath("") + File.separator + "proguard.pro";
//                        Main Obfusacate = new Main();
//                        Obfusacate.obfuscation(args);
//                        request.setAttribute("download", request.getSession().getServletContext().getRealPath("") + File.separator + "obfuscation_out.jar");


                        String[] input = new String[2];
                        input[0] = request.getSession().getServletContext().getRealPath("") + File.separator + new File(item.getName()).getName();
                        input[1] = request.getSession().getServletContext().getRealPath("");

                        new Hw5Johnsons().main(input);
                        request.setAttribute("download", request.getSession().getServletContext().getRealPath("") + File.separator + "output.txt");


                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded and Obfuscation was successful");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }


        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);

    }

}