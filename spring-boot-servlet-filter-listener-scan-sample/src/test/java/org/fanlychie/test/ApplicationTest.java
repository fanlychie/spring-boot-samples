package org.fanlychie.test;

import org.fanlychie.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/7/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testController() {
        restTemplate.getForObject("/home", String.class);
    }

    @Test
    public void testServlet() {
        restTemplate.getForObject("/customServlet", Object.class);
    }

}