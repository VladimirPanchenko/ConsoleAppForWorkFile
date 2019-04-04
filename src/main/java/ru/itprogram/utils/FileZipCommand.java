package ru.itprogram.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipCommand implements Command {
    private final String KEY_COMMAND = "zip";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        String[] paths = Arrays.copyOfRange(strings, 1, strings.length);
        createZipFile(strings[1], paths);
    }

    public static void createZipFile(String zipFile, String[] paths) {
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < paths.length; i++) {
            try {
                zipOutputStream.putNextEntry(new ZipEntry(paths[i]));
                byte[] data = new FileReadCommand().readFile(paths[i]).toString().getBytes();
                zipOutputStream.write(data);
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
