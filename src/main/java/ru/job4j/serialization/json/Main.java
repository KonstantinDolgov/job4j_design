package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

        /* JSONObject из json-строки строки */
        JSONObject jsonAnimal = new JSONObject("{\"kind\":\"Tiger\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("boar");
        list.add("goat");
        JSONArray jsonNutritiones = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Forest forest1 = new Forest(true, 600,
                new Animal("Tiger"), new String[]{"boar", "goat"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("predator", forest1.isPredator());
        jsonObject.put("weight", forest1.getWeight());
        jsonObject.put("animal", jsonAnimal);
        jsonObject.put("nutritiones", jsonNutritiones);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(forest1).toString());
    }
}
