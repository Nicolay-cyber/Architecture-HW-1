package ru.gb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {
    private final String folder;
    private final String name;
    private Path path;

    public File(String folder, String name) {
        this.folder = folder;
        this.name = name;
        createPath();
    }

    public Path getPath() {
        return path;
    }

    public boolean isPathEmpty() {
        return !Files.exists(path);
    }

    public void createPath() {
        this.path = Paths.get(folder, name);
    }
}
