package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty()
                .startsWith("S");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotEmpty()
                .startsWith("C");
    }

    @Test
    void numberOfVerticesIsFour() {
        Box box = new Box(4, 5);
        int countOfVertices = box.getNumberOfVertices();
        assertThat(countOfVertices).isEqualTo(4)
                .isPositive();
    }

    @Test
    void numberOfVerticesIsEight() {
        Box box = new Box(0, 4);
        int countOfVertices = box.getNumberOfVertices();
        assertThat(countOfVertices).isEqualTo(0)
                .isNotPositive();
    }

    @Test
    void isExist() {
        Box box = new Box(8, 3);
        boolean isExist = box.isExist();
        assertThat(isExist).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(-1, 3);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse();
    }

    @Test
    void areaIs113() {
        Box box = new Box(0, 3);
        double getArea = box.getArea();
        assertThat(getArea).isEqualTo(113d, withPrecision(0.1d))
                .isGreaterThan(110d);
    }

    @Test
    void areaIs150() {
        Box box = new Box(8, 5);
        double getArea = box.getArea();
        assertThat(getArea).isEqualTo(150d, withPrecision(0.1d))
                .isGreaterThan(140d);
    }
}
