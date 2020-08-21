package com.dip.bootcamp.utilities;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;



public class JsonHelper {

    public static String toJsonString(Object o) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.disableHtmlEscaping().create();

        return gson.toJson(o);
    }

}
