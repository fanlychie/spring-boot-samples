package org.fanlychie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanlychie on 2017/7/2.
 */
@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        System.out.println("------ Controller ------");
        return "home";
    }

}