package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ThreadService {
    AtomicInteger j = new AtomicInteger(0);

    public String start() {
        ChangeService thread1 = new ChangeService(j, "1", "ASCENT", 2);
        ChangeService thread2 = new ChangeService(j, "2", "ASCENT", 4);
        ChangeService thread3 = new ChangeService(j, "3", "DESCENT", 5);
        ChangeService thread4 = new ChangeService(j, "4", "DESCENT", 3);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        return "ok";
    }
}
