package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkArgs(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder has a value not equal to three. Usage ROOT_FOLDER.");
        }
        if (!Files.isDirectory(Paths.get(argsName.get("d")))) {
            throw new IllegalArgumentException("Root folder address is not set correctly. Usage ROOT_FOLDER.");
        }
        if (!argsName.get("e").startsWith(".") || argsName.get("e").length() < 2) {
            throw new IllegalArgumentException("Root folder the wrong file extension was passed. Usage ROOT_FOLDER.");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Root folder the wrong file extension was passed.zip. Usage ROOT_FOLDER.");
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        checkArgs(args);
        Zip zip = new Zip();
        ArgsName arg = ArgsName.of(args);
        List<Path> list = Search.search(Paths.get(arg.get("d")),
                prd -> !prd.toFile().getName().endsWith(arg.get("e")));
        zip.packFiles(list, new File(arg.get("o")));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}