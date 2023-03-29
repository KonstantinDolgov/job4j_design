package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Forest forest = new Forest(true, 600,
                new Animal("Tiger"), new String[]{"boar", "goat"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(forest));
        final String forestJson =
                "{"
                        + "\"predator\":true,"
                        + "\"weight\":600,"
                        + "\"animal\":"
                        + "{"
                        + "\"kind\":\"Tiger\""
                        + "},"
                        + "\"nutrition\":"
                        + "[\"boar\",\"goat\"]"
                        + "}";
        final Forest forestMod = gson.fromJson(forestJson, Forest.class);
        System.out.println(forestMod);
    }
}
