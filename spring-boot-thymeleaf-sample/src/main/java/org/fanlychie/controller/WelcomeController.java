package org.fanlychie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fanlychie on 2017/7/16.
 */
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(ModelMap model) {
        model.put("message", "Hello Thymeleaf!");
        return "index";
    }

}