package org.fanlychie;

import org.fanlychie.config.AppConfig;
import org.fanlychie.config.AppWithJSR303Config;
import org.fanlychie.config.CommandLineConfig;
import org.fanlychie.config.DataStructureConfig;
import org.fanlychie.config.EmailConfig;
import org.fanlychie.config.EmailValueConfig;
import org.fanlychie.config.JdbcConfig;
import org.fanlychie.config.LayoutConfig;
import org.fanlychie.config.RandomSeedConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fanlychie on 2017/7/3.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DataStructureConfig dataStructureConfig;

    @Value("${app.description}")
    private String description;

    @Autowired
    private EmailValueConfig emailValueConfig;

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private LayoutConfig layoutConfig;

    @Autowired
    private AppWithJSR303Config appWithJSR303Config;

    @Autowired
    private RandomSeedConfig randomSeedConfig;

    @Autowired
    private JdbcConfig jdbcConfig;

    @Autowired
    private CommandLineConfig commandLineConfig;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------------------------------");
        System.out.println(emailValueConfig);
        System.out.println(emailConfig);
        System.out.println(appConfig);
        System.out.println(layoutConfig);
        System.out.println(appWithJSR303Config);
        System.out.println(randomSeedConfig);
        System.out.println(jdbcConfig);
        System.out.println(description);
        System.out.println(dataStructureConfig);
        System.out.println(commandLineConfig);
        System.out.println("-------------------------------------------");
    }

}