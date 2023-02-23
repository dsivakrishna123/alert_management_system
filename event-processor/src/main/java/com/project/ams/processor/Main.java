package com.project.ams.processor;

import java.util.Timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Timer().scheduleAtFixedRate(new Task(new Processor()), 0, 1000L);
        Thread.sleep(200000);
    }
}
