package com.oliveira.pages.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    public static Gson build() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        return builder.create();
    }

}
