package ru.itprogram.utils;

import ru.itprogram.exceptions.FileNotDeletesException;

import java.io.File;
import java.io.FileNotFoundException;

public class FileDeleteCommand implements Command {
    private final String KEY_COMMAND = "deleteFile";
    private static final String FILE_NOT_FOUND = "Не найден файл по указанному пути";
    private static final String FILE_NOT_DELETES = "Внимание!!! Удалить файл не удалось!";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        deleteFile(strings[1]);
    }

    private void deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException(FILE_NOT_FOUND);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            boolean deleteFile = file.delete();
            if (!deleteFile) {
                try {
                    throw  new FileNotDeletesException(FILE_NOT_DELETES);
                } catch (FileNotDeletesException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
