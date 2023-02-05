package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        input.add(3);
        input.add(3);
        input.add(4);
        ListUtils.removeIf(input, t -> t == 3);
        assertThat(input).hasSize(2).containsSequence(1, 4);
    }

    @Test
    void whenReplaceIf() {
        input.add(2);
        input.add(3);
        input.add(4);
        ListUtils.replaceIf(input, t -> t == 3, 77);
        assertThat(input).hasSize(5).containsSequence(1, 77, 2, 77, 4);
    }

    @Test
    void whenRemoveAll() {
        input.add(2);
        input.add(3);
        input.add(4);
        ListUtils.removeAll(input, List.of(2, 3));
        assertThat(input).hasSize(2).containsSequence(1, 4);
    }
}