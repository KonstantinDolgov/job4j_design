package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.StringJoiner;

public class ResultFile {
    public static String multiple(int size) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                int rsl = (row + 1) * (cell + 1);
                joiner.add(String.valueOf(rsl));
            }
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write((multiple(3)).getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}