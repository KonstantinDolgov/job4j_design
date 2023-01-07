package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("1", "2", "3", "4", "5");
        assertThat(list).hasSize(5)
                .contains("2")
                .contains("2", Index.atIndex(1))
                .containsAnyOf("0", "2", "7")
                .doesNotContain("1", Index.atIndex(1))
                .startsWith("1");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("9", "5", "4", "3", "2", "3", "1");
        assertThat(set).hasSize(6)
                .contains("3")
                .containsAnyOf("0", "9", "7")
                .allSatisfy(e -> {
                    assertThat(Integer.valueOf(e)).isLessThan(10);
                    assertThat(Integer.valueOf(e)).isGreaterThan(0);
                })
                .noneMatch(e -> e.equals("7"));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("three", "five")
                .containsEntry("second", 1)
                .containsValues(1, 2, 0)
                .doesNotContainValue(5);
    }
}