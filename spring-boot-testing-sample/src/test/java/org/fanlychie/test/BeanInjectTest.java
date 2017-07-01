package org.fanlychie.test;

import org.fanlychie.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanInjectTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testSayHi() {
        System.out.println(helloService.sayHi());
    }

}