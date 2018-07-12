package org.fanlychie.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;

@Configuration
public class ApplicationConfig {

    /**
     * 测试队列1
     *
     * @param queueNameTest1 通过配置文件将自定义的值注入进来
     * @return
     */
    @Bean
    public Queue queueTest1(@Value("${activemq.queue-name.test1}") String queueNameTest1) {
        return new ActiveMQQueue(queueNameTest1);
    }

    /**
     * 测试队列2
     *
     * @param queueNameTest2 通过配置文件将自定义的值注入进来
     * @return
     */
    @Bean
    public Queue queueTest2(@Value("${activemq.queue-name.test2}") String queueNameTest2) {
        return new ActiveMQQueue(queueNameTest2);
    }

}