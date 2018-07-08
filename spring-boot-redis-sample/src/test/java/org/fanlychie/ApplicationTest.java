package org.fanlychie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanlychie on 2018/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void doTest() {
        if (redisTemplate.hasKey("infomsg")) {
            System.out.println("=====> " + redisTemplate.opsForValue().get("infomsg"));
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "fanlychie");
            map.put("mail", "fanlychie@yeah.net");
            redisTemplate.opsForValue().set("infomsg", map);
        }
    }

}