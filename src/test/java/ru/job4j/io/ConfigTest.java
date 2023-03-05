package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Konstantin");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("id")).isEqualTo("Pasport");
    }

    @Test
    void whenPairWithSpaceAfterEquals() {
        String path = "./data/pair_with_space_after_equals.properties";
        Config config = new Config(path);
        Throwable thrown = assertThrows(IllegalArgumentException.class, config::load);
        assertEquals("Invalid line!", thrown.getMessage());
    }

    @Test
    void whenPairWithSpaceBeforeEquals() {
        String path = "./data/pair_with_space_before_equals.properties";
        Config config = new Config(path);
        Throwable thrown = assertThrows(IllegalArgumentException.class, config::load);
        assertEquals("Invalid line!", thrown.getMessage());
    }

    @Test
    void whenPairWithOnlyEquals() {
        String path = "./data/line_equals_=.properties";
        Config config = new Config(path);
        Throwable thrown = assertThrows(IllegalArgumentException.class, config::load);
        assertEquals("Invalid line!", thrown.getMessage());
    }

    @Test
    void whenPairWithEqualsAfterValue() {
        String path = "./data/pair_with_value=1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=1");
    }
}