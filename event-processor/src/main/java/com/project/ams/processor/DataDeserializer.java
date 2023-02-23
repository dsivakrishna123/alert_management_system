package com.project.ams.processor;

import com.google.gson.*;

import java.lang.reflect.Type;

public class DataDeserializer implements JsonDeserializer<Coin> {

    @Override
    public Coin deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String time = null;
        Double rate = null;
        if (jsonObject.has("time")) {
            JsonObject t = jsonObject.getAsJsonObject("time");
            time = t.get("updated").getAsString();
        }
        if (jsonObject.has("bpi")) {
            JsonObject bpi = jsonObject.getAsJsonObject("bpi");
            rate = Double.parseDouble(bpi.getAsJsonObject("USD").get("rate").getAsString().replace(",",""));
        }

        return new Coin("BitCoin", rate, time);
    }



}
