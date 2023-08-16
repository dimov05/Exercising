package com.spring.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service

public class TrafficFortuneService {

    public String getFortune() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);


        return "Expect heavy traffic this morning";
    }
}
