package ru.itprogram.utils;

public interface Command {
    String key();
    void run(String[] strings);
}
