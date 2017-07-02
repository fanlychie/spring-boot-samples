package org.fanlychie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanlychie on 2017/7/2.
 */
@Controller
public class UserController {

    @GetMapping(value = "/user/index", headers = "content-type=text/*")
    public String index(Integer uid, HttpServletResponse response) throws Exception {
        if (!uid.equals(1001)) {
            response.sendError(HttpStatus.FORBIDDEN.value());
        }
        if (uid < 100) {
            throw new RuntimeException("模拟服务器端发生的异常");
        }
        return "index";
    }

}