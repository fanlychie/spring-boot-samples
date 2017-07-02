package org.fanlychie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by fanlychie on 2017/7/2.
 */
@SpringBootApplication
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}