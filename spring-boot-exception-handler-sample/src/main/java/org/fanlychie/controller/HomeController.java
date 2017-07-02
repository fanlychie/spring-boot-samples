package org.fanlychie.controller;

import org.fanlychie.exception.BusinessHtmlException;
import org.fanlychie.exception.BusinessJsonException;
import org.fanlychie.http.HttpResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanlychie on 2017/7/2.
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        throw new BusinessHtmlException("模拟浏览器访问时服务器端发生的异常");
    }

    @GetMapping("/home/info")
    public @ResponseBody HttpResponseBody info() {
        throw new BusinessJsonException("模拟客户端调用时服务器端发生的异常");
    }

}