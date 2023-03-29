package ru.job4j.serialization.json;

public class Animal {
    private final String kind;

    public Animal(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "kind='" + kind + '\''
                + '}';
    }
}
