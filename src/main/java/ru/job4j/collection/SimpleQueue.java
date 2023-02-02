package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int count = 0;

    public T poll() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        count--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        count++;
        if (count == 1) {
            out.push(in.pop());
        } else {
            T tmpOut = out.pop();
            out.push(in.pop());
            out.push(tmpOut);
        }
    }
}