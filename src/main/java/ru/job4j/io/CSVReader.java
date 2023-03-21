package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        List<String> data = readFile(path);
        writeData(data, filter, out, delimiter);
    }

    private static List<String> readFile(String path) {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(path)).useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void writeData(List<String> data, String filter, String out, String delimiter) {
        String[] filters = filter.split(",");
        String[] dataHeaders = data.get(0).split(delimiter);
        List<Integer> indexes = new ArrayList<>();
        for (String s : filters) {
            for (int e = 0; e < dataHeaders.length; e++) {
                if (s.equals(dataHeaders[e])) {
                    indexes.add(e);
                }
            }
        }
        String[] tmp;
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : data) {
            tmp = str.split(delimiter);
            for (Integer integer : indexes) {
                result.append(tmp[integer]).append(delimiter);
            }
            stringBuilder.append(result.toString(), 0, result.length() - 1).append(System.lineSeparator());
            result = new StringBuilder();
        }
        if ("stdout".equals(out)) {
            System.out.println(stringBuilder);
        } else {
            try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(out)))) {
                printWriter.write(stringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void validate(ArgsName argsName) {
        File file = new File(argsName.get("path"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Invalid delimiter");
        }
        if (!"stdout".equals(argsName.get("out")) && (argsName.get("out").length() < 5
                || !argsName.get("out").endsWith(".csv"))) {
            throw new IllegalArgumentException("Invalid output name");
        }
        if ("".equals(argsName.get("filter"))) {
            throw new IllegalArgumentException("Invalid filter");
        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid number of parameters. Specify the required parameters.");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}