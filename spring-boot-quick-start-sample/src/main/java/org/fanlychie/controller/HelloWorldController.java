package org.fanlychie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanlychie on 2017/7/16.
 */
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

}