package com.springUsersAccess.controller;

import com.springUsersAccess.delegate.SignupDelegate;
import com.springUsersAccess.viewBean.LoginBean;
import com.springUsersAccess.viewBean.SignupBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 */

@Controller
public class SignupController {
    private final SignupDelegate signupDelegate;

    @Autowired
    public SignupController(SignupDelegate signupDelegate) {
        this.signupDelegate = signupDelegate;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView displaySignup(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("signup");
        SignupBean signupBean = new SignupBean();
        model.addObject("signupBean", signupBean);
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView executeSignup(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("signupBean") SignupBean signupBean) {
        // TODO: find out if returning a null model is an acceptable practice
        ModelAndView model = null;
        try {
            if (!signupDelegate.isUsernameAllowed(signupBean.getUsername())) {
                request.setAttribute("username_msg", "Username is already taken");
                // Take the user back to the signup screen
                model = new ModelAndView("signup");
            }
            else if (!signupDelegate.isPasswordAllowed(signupBean.getPassword())) {
                request.setAttribute("password_msg", "Password is too weak");
                // Take the user back to the signup screen
                model = new ModelAndView("signup");
            }
            else {
                // TODO give the user input that they have made their account

                signupDelegate.createUser(signupBean.getUsername(), signupBean.getPassword());

                // Create a model object to take the user to the login screen
                model = new ModelAndView("login");

                // Create a login bean based on input to used to make the new user
                LoginBean loginBean = new LoginBean();
                loginBean.setUsername(signupBean.getUsername());
                loginBean.setPassword(signupBean.getPassword());

                model.addObject("loginBean", loginBean);
                request.setAttribute("message",
                        "An account for " + signupBean.getUsername() + " was successfully created!\n"
                        + "You are now signed in.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }
}
