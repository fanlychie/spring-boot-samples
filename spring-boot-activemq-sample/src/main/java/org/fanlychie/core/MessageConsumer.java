package org.fanlychie.core;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    /**
     * 接收处理测试队列1的消息
     *
     * @param message 消息内容
     */
    @JmsListener(destination = "QUEUE_TEST1")
    public void receiveQueueTest1Message(String message) {
        System.out.println("====>> [QUEUE_TEST1] 收到消息：" + message);
    }

    /**
     * 接收处理测试队列2的消息
     *
     * @param message 消息内容
     */
    @JmsListener(destination = "QUEUE_TEST2")
    public void receiveQueueTest2Message(String message) {
        System.out.println("====>> [QUEUE_TEST2] 收到消息：" + message);
    }

}