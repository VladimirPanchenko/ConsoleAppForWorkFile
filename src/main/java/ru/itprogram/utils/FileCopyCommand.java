package ru.itprogram.utils;

import java.io.File;

public class FileCopyCommand implements Command {
    private final String KEY_COMMAND = "cp";
    private final String ADDITIONAL_PARAMETER = "-a";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        if (strings[1].equals(ADDITIONAL_PARAMETER)) {
            copyFile(strings[2], strings[3], true);
        } else {
            copyFile(strings[1], strings[2], false);
        }
    }

    private void copyFile(String source, String dest, boolean append) {
        File file = new File(source);
        FileWriteCommand fileWriteCommand = new FileWriteCommand();
        StringBuilder stringBuilder = new FileReadCommand().readFile(source);
        if (file.exists()) {
            fileWriteCommand.onlyWriteFile(dest, String.valueOf(stringBuilder), append);
        } else {
            new FileCreateCommand().createFile(dest);
            fileWriteCommand.onlyWriteFile(dest, String.valueOf(stringBuilder), append);
        }
    }
}
