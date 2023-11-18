package com.practice.send_service.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Date;

@Component
public class DateDeserializer
        implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) {
        long unixTime = json.getAsJsonPrimitive().getAsLong();
        return new Date(unixTime);
    }

}

