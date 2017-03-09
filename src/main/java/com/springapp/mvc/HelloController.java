package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shuai Zheng on 1/29/17.
 */

@Controller
public class HelloController {
    //    @RequestMapping(method = RequestMethod.GET)
    @RequestMapping("/")
    public String printWelcome(ModelMap model, @RequestParam(value = "username", required = false) String username, HttpServletRequest request,
                               HttpServletResponse response) {
//        if (param2!="")
        System.out.println("Current user: " + username);  //DEBUG PRINTF
        if (username == null || username == "") {
            String message = "please login first.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login").forward(request, response);
            return null;
        } else {
            model.addAttribute("username", username);

            return "index";


        }
    }
}