package com.project.ams.processor;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);
    private PropertyLoader propertyLoader = new PropertyLoader();

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
            LOGGER.info(JsonParser.parseCoin(body.string()).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
