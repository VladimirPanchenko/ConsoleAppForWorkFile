package ru.itprogram.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteCommand implements Command {
    private final String KEY_COMMAND = "writeFile";
    private final String ADDITIONAL_PARAMETER = "-a";
    private final String FILE_NOT_FOUND_NEW_FILE = "Не найден файл по указанному пути," +
            " сначала его нежно создать!";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        if (strings[1].equals(ADDITIONAL_PARAMETER)) {
            writeFile(strings[2], strings[3], true);
        } else {
            writeFile(strings[1], strings[2], false);
        }
    }

    private void writeFile(String path, String string, boolean append) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException(FILE_NOT_FOUND_NEW_FILE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            onlyWriteFile(path, string, append);
        }
    }

    public void onlyWriteFile(String path, String string, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            fileWriter.write(string);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
