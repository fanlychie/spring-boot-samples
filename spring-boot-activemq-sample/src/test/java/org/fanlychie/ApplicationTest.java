package org.fanlychie;

import org.fanlychie.core.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2018/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void doTest() {
        messageProducer.sendToQueueTest1("Hello");
        messageProducer.sendToQueueTest2("World");
    }

}