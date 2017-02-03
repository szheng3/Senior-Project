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


@Controller
public class LoginController {
    private final LoginDelegate loginDelegate;

    @Autowired
    public LoginController(LoginDelegate loginDelegate) {
        this.loginDelegate = loginDelegate;
    }

    /**
     * Method used when the user firsts access the login page. Since it will be a GET request, the login
     * form is provided when the user accesses the login page.
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {

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
     * @param request
     * @param response
     * @param loginBean
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("loginBean") LoginBean loginBean) {
        ModelAndView model = null;
        try {
            boolean isValidUser = loginDelegate.isAuthenticUser(loginBean.getUsername(), loginBean.getPassword());
            if (isValidUser) {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("welcome");
            }
            else {
                System.out.println("User Login Unsuccessful");
                model = new ModelAndView("login");
                model.addObject("loginBean", loginBean);
                request.setAttribute("message", "Invalid credentials!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
