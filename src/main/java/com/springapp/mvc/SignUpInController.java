package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shuai Zheng on 1/29/17.
 */

@Controller
public class SignUpInController {
    @RequestMapping("/SignIn")
    public String SignInMVC(ModelMap model) {
        model.addAttribute("message", "Machine Learning");
        return "SignIn";
    }

    @RequestMapping("/SignUp")
    public String SignUpMVC(ModelMap model) {
        model.addAttribute("message", "Machine Learning");
        return "SignUp";
    }
}
