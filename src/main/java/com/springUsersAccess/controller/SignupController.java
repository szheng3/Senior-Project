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

import java.sql.SQLException;

/**
 * Created by Alex Almanza on 2/4/17.
 */

@Controller
@RequestMapping(value = "/signup")
public class SignupController {


    private final SignupDelegate signupDelegate;

    @Autowired
    public SignupController(SignupDelegate signupDelegate) {
        this.signupDelegate = signupDelegate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displaySignup() {
        ModelAndView model = new ModelAndView("signup");
        SignupBean signupBean = new SignupBean();
        model.addObject("signupBean", signupBean);
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView executeSignup(@ModelAttribute("signupBean") SignupBean signupBean) {
        // TODO: find out if returning a null model is an acceptable practice
        ModelAndView model = null;
        try {
            if (!signupDelegate.isUsernameAvailable(signupBean.getUsername())) {
                // Take the user back to the signup screen
                model = new ModelAndView("signup");
                model.addObject("username_msg", "*Username is already taken");
            }
            else if (!signupDelegate.isPasswordAllowed(signupBean.getPassword())) {
                // Take the user back to the signup screen
                model = new ModelAndView("signup");
                model.addObject("password_msg", "*Password is too weak");
            }
            else if (!signupDelegate.isFormatCorrect(signupBean.getUsername())) {
                // Take the user back to the signup screen
                model = new ModelAndView("signup");
                // TODO specify format in a better way that is globally accessible
                model.addObject("username_msg", "*Username has wrong format:");
            }
            else {
                // TODO give the user input that they have made their account
                signupDelegate.createUser(signupBean.getUsername(), signupBean.getPassword());

                // Create a model object to take the user to the login screen
//                model = new ModelAndView("redirect:/login");
                model = new ModelAndView("../index");
                model.addObject("username", signupBean.getUsername());



                // Create a login bean based on input to used to make the new user
                LoginBean loginBean = new LoginBean();
                loginBean.setUsername(signupBean.getUsername());
                loginBean.setPassword(signupBean.getPassword());

                model.addObject("loginBean", loginBean);
                model.addObject("message",
                                String.format("An account for %s was successfully created!", signupBean.getUsername()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model = new ModelAndView("error");
            model.addObject("error_message", "Database error");
        }

        return model;
    }
}
