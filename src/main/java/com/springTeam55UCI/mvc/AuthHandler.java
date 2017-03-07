package com.springTeam55UCI.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Created by Leo on 3/2/2017.
 */
public class AuthHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Current user: "+username);  //DEBUG PRINTF
        if(username==null) {
            String message = "please login first.";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}