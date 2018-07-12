package org.fanlychie.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;

@Component
public class MessageProducer {

    @Autowired
    private Queue queueTest1;

    @Autowired
    private Queue queueTest2;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息到测试队列1
     *
     * @param message 消息内容
     */
    public void sendToQueueTest1(String message) {
        jmsTemplate.convertAndSend(queueTest1, message);
    }

    /**
     * 发送消息到测试队列2
     *
     * @param message 消息内容
     */
    public void sendToQueueTest2(String message) {
        jmsTemplate.convertAndSend(queueTest2, message);
    }

}