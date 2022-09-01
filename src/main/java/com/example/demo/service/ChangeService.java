package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeService extends Thread {
    AtomicInteger j;
    String nameA;
    String operation;
    int amountOfIteration;

    @Override
    public void run() {
        for (int i = 0; i < amountOfIteration; i++) {
            if (operation.equals("ASCENT")) {
                j.incrementAndGet();
            } else {
                j.decrementAndGet();
            }
            System.out.println(nameA + ": " + j.get());
        }
    }
}
