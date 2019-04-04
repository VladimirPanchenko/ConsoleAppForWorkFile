package ru.itprogram.utils;

public class ExitCommand implements Command {
    private final String KEY_COMMAND = "exit";

    @Override
    public String key() {
        return KEY_COMMAND;
    }

    @Override
    public void run(String[] strings) {
        System.exit(0);
    }
}
