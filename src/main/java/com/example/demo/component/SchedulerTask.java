package com.example.demo.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yy:MM:dd HH:mm:ss");
    @Scheduled(fixedRate = 6000)
    public void sysoDate(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
