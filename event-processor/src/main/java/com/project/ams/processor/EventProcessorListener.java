package com.project.ams.processor;

import okhttp3.Call;
import okhttp3.EventListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


public class EventProcessorListener extends EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventProcessorListener.class);

    @Override
    public void callStart(@NotNull Call call) {
        LOGGER.info("callStart at {}", LocalDateTime.now());
    }

    @Override
    public void callEnd(@NotNull Call call) {
        LOGGER.info("callEnd at {}", LocalDateTime.now());
    }
}
