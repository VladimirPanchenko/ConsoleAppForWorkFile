package ru.itprogram.utils;

import java.io.File;
import java.io.IOException;

public class FileCreateCommand implements Command {
    private final String KEY_COMMAND = "createFile";
    private static final String FILE_SUCCESSFULLY_CREATED = "Файл успешно создан!";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        createFile(strings[1]);
    }

    public void createFile(String path) {
        File file = new File(path);
        try {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println(FILE_SUCCESSFULLY_CREATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
