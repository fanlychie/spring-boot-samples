package org.fanlychie.core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTask {

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayTask() throws InterruptedException {
        System.out.println("[fixedDelay] " + LocalDateTime.now());
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    @Scheduled(fixedRate = 5000)
    public void fixedRateTask() throws InterruptedException {
        System.out.println("[fixedRate] " + LocalDateTime.now());
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    @Scheduled(initialDelay = 2000, fixedRate = 5000)
    public void initialDelayTask() throws InterruptedException {
        System.out.println("[initialDelay] " + LocalDateTime.now());
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void cronTask() throws InterruptedException {
        System.out.println("[cron] " + LocalDateTime.now());
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}