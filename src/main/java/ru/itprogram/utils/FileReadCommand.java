package ru.itprogram.utils;

import java.io.FileReader;
import java.io.IOException;

public class FileReadCommand implements Command {
    private final String KEY_COMMAND = "cat";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        print(readFile(strings[1]));
    }

    public StringBuilder readFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(path);
            int c;
            while ((c = fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    private void print(StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
    }
}
