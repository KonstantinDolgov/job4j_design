package ru.job4j.io;

import java.io.*;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String line;
            boolean checkServer = true;
            while ((line = reader.readLine()) != null) {
                if ((line.startsWith("400") || line.startsWith("500")) && checkServer) {
                    checkServer = false;
                    writer.write(line.split(" ")[1]);
                    writer.write(";");
                }
                if (!(line.startsWith("400") || line.startsWith("500")) && !checkServer) {
                    checkServer = true;
                    writer.write(line.split(" ")[1]);
                    writer.write(";");
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}