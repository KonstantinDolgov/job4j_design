package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "forest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Forest {
    @XmlAttribute
    private boolean predator;
    @XmlAttribute
    private int weight;
    private Animal animal;
    @XmlElementWrapper(name = "nutritiones")
    @XmlElement(name = "nutrition")
    private String[] nutrition;

    public Forest() {
    }

    public Forest(boolean predator, int weight, Animal animal, String[] nutrition) {
        this.predator = predator;
        this.weight = weight;
        this.animal = animal;
        this.nutrition = nutrition;
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
