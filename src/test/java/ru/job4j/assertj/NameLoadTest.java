package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNamesEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void nameNotContainsEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Two"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: Two does not contain the symbol \"=\"");
    }

    @Test
    void nameStartWithEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("= 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: = 2 does not contain a key");
    }

    @Test
    void nameEndWithEqualSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Car ="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: Car = does not contain a value");
    }
}