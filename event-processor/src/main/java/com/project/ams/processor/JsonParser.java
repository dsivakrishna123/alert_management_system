package com.project.ams.processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson;
    static {
        builder.registerTypeAdapter(Coin.class, new DataDeserializer());
        gson = builder.create();
    }

    private JsonParser() {
        // restricts from creating new instances
    }

    static Coin parseCoin(String coin){
        return  gson.fromJson(coin, Coin.class);
    }
}
