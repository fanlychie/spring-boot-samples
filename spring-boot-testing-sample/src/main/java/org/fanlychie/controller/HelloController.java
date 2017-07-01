package org.fanlychie.controller;


import org.fanlychie.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanlychie on 2017/7/1.
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(ModelMap model) {
        model.put("message", "Hello Page");
        return "hello";
    }

    @GetMapping("/hello/sayHi")
    public String sayHi(ModelMap model) {
        model.put("message", helloService.sayHi());
        return "hello";
    }

    @GetMapping("/hello/sayHello")
    public @ResponseBody Object sayHello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", helloService.sayHello());
        return map;
    }

}