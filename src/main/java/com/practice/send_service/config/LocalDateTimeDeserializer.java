package com.practice.send_service.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class LocalDateTimeDeserializer
        implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) {
        JsonArray jsonArray = json.getAsJsonArray();
        int unixData = jsonArray.get(0).getAsInt() / 1000;
        Instant instant = Instant.ofEpochMilli(unixData);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /*    @Override
    public LocalDateTime deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) {
        JsonArray jsonArray = json.getAsJsonArray();
        int year = jsonArray.get(0).getAsInt();
        int month = jsonArray.get(1).getAsInt();
        int day = jsonArray.get(2).getAsInt();
        int hour = jsonArray.get(3).getAsInt();
        int minute = jsonArray.get(4).getAsInt();
        int second = jsonArray.get(5).getAsInt();
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }*/

}

