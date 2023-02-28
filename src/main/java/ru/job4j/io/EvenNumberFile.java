package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder numbers = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                numbers.append((char) read);
            }
            String[] nums = numbers.toString().split(System.lineSeparator());
            for (String num : nums) {
                if (Integer.parseInt(num) % 2 == 0) {
                    System.out.println(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
