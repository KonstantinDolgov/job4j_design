package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String s = scanner.nextLine();
        log.add(s);
        System.out.println("Диалог начался!");
        while (!OUT.equals(s)) {
            String rsl = cc.readPhrases().get((int) (Math.random() * readPhrases().size()));
            System.out.println(rsl);
            log.add(rsl);
            if (STOP.equals(s)) {
                System.out.println("Остановлен диалог!");
                while (!CONTINUE.equals(s)) {

                    s = scanner.nextLine();
                    log.add(s);
                }
            }
            if (s.equals(CONTINUE)) {
                System.out.println("Продолжаем диалог!");
            }
            s = scanner.nextLine();
            log.add(s);
        }
        System.out.println("Чат завершен");
        cc.saveLog(log);
        scanner.close();
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers))) {
            String line;
            while ((line = read.readLine()) != null) {
                phrases.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintStream printStream = new PrintStream(path)) {
            for (String i : log) {
                printStream.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/log_of_dialog.txt", "data/answers.txt");
        cc.run();
    }
}
