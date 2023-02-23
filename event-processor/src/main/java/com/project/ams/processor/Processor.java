package com.project.ams.processor;

import com.project.arm.producer.EventProducer;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);
    private PropertyLoader propertyLoader = new PropertyLoader();
    private EventProducer producer;

    public Processor() {
        producer = new EventProducer();
        producer.initializeProducer();
    }

    public void start() {
        OkHttpClient client = new OkHttpClient.Builder()
                .eventListener(new EventProcessorListener())
                .build();
        String url = propertyLoader.getProperty("coin_desk.url");
        LOGGER.info("Received URL {}", url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response;
        try {
            response = call.execute();
            int statusCode = response.code();
            LOGGER.info("response receive with status code {}", statusCode);
            ResponseBody body = response.body();
            assert body != null;
            producer.addRecord("bitcoin_new", body.string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
