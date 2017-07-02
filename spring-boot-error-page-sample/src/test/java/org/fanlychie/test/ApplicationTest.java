package org.fanlychie.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by fanlychie on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test400() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index?uid=xxx",
                HttpMethod.GET, buildHeaderEntity(), String.class);
        print(response);
    }

    @Test
    public void test403() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index?uid=111",
                HttpMethod.GET, buildHeaderEntity(), String.class);
        print(response);
    }

    @Test
    public void test404() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index/1111111",
                HttpMethod.GET, buildHeaderEntity(), String.class);
        print(response);
    }

    @Test
    public void test405() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index?uid=1001",
                HttpMethod.POST, buildHeaderEntity(), String.class);
        print(response);
    }

    @Test
    public void test415() {
        String htmlPage = restTemplate.getForObject("/user/index?uid=1001", String.class);
        System.out.println("================================================");
        System.out.println(htmlPage);
        System.out.println("================================================");
    }

    @Test
    public void test500() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index?uid=99",
                HttpMethod.GET, buildHeaderEntity(), String.class);
        print(response);
    }

    @Test
    public void testNormal() {
        ResponseEntity<String> response = restTemplate.exchange("/user/index?uid=1001",
                HttpMethod.GET, buildHeaderEntity(), String.class);
        print(response);
    }

    private HttpEntity<?> buildHeaderEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        return new HttpEntity<>("parameters", headers);
    }

    private void print(ResponseEntity<String> response) {
        System.out.println("================================================");
        System.out.println(response.getBody());
        System.out.println("================================================");
    }

}