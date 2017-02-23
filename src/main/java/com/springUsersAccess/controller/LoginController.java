package com.springUsersAccess.controller;

/**
 * Created by Alex Almanza on 1/31/17.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springUsersAccess.delegate.LoginDelegate;
import com.springUsersAccess.viewBean.LoginBean;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private final LoginDelegate loginDelegate;

    @Autowired
    public LoginController(LoginDelegate loginDelegate) {
        this.loginDelegate = loginDelegate;
    }

    /**
     * Method used when the user firsts access the login page. Since it will be a GET request, the login
     * form is provided when the user accesses the login page.
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayLogin() {

        // Creates a ModelAndView object with a view of 'login'
        // the page for 'login' is then determined by InternalResourceViewResolver,
        // which is defined inside springBeanConfiguration.xml
        ModelAndView model = new ModelAndView("login");

        // associates a new instance of a LoginBean to the model
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);

        return model;
    }

    /**
     * A method that is called when a user makes a login attempt. If the user provided valid credentials, then they are
     * directed to the welcom page. Otherwise, the user is navigated back to the login page.
     * @param loginBean
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView executeLogin(@ModelAttribute("loginBean") LoginBean loginBean) {

        // ModelAndView object will be defined to according to the validity of the provided credentials
        ModelAndView model = null;

        try {
            // Check if the user provided the proper credentials
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());

            // Defines the model object that will take the user to the proper page
            if (isValidUser) {
                // TODO create service that actually signs in user, right now only credentials are checked
                System.out.println("User Login Successful");
                model = new ModelAndView("welcome");
                // TODO create a new view class for a signed in user
                model.addObject("username", loginBean.getUsername());
            }
            else {
                System.out.println("User Login Unsuccessful");
                model = new ModelAndView("login");
                model.addObject("loginBean", loginBean);
                model.addObject("message", "*  Username or password is invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model = new ModelAndView("error");
            model.addObject("error_message", "Database error");
        }

        return model;
    }
}
