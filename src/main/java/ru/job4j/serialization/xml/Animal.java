package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "animal")
public class Animal {
    @XmlAttribute
    private String kind;

    public Animal() {
    }

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
