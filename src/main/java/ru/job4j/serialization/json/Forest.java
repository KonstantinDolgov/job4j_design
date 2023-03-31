package ru.job4j.serialization.json;

import java.util.Arrays;

public class Forest {
    private final boolean predator;
    private final int weight;
    private final Animal animal;
    private final String[] nutrition;

    public Forest(boolean predator, int weight, Animal animal, String[] nutrition) {
        this.predator = predator;
        this.weight = weight;
        this.animal = animal;
        this.nutrition = nutrition;
    }

    public boolean isPredator() {
        return predator;
    }

    public int getWeight() {
        return weight;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String[] getNutrition() {
        return nutrition;
    }

    @Override
    public String toString() {
        return "Forest{"
                + "predator=" + predator
                + ", weight=" + weight
                + ", animal=" + animal
                + ", nutrition=" + Arrays.toString(nutrition)
                + '}';
    }
}