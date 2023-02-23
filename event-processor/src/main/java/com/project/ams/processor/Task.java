package com.project.ams.processor;

import java.util.TimerTask;

public class Task extends TimerTask {
    private final Processor processor;

    public Task(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.start();
    }
}
