package com.project.ams.processor;

import okhttp3.OkHttpClient;

public class Processor {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                .eventListener(new EventProcessorListener())
                .build();
    }
}
