package org.fanlychie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testThrowHtmlException() {
        String htmlPage = restTemplate.getForObject("/home", String.class);
        System.out.println("================================================");
        System.out.println(htmlPage);
        System.out.println("================================================");
    }

    @Test
    public void testThrowJsonException() {
        String jsonResult = restTemplate.getForObject("/home/info", String.class);
        System.out.println("================================================");
        System.out.println(jsonResult);
        System.out.println("================================================");
    }

}