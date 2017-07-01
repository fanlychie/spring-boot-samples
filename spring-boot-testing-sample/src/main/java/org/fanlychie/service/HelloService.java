package org.fanlychie.service;

import org.springframework.stereotype.Service;

/**
 * Created by fanlychie on 2017/7/1.
 */
@Service
public class HelloService {

    public String sayHi() {
        return "--- Hi ---";
    }

    public String sayHello() {
        return "--- Hello ---";
    }

}