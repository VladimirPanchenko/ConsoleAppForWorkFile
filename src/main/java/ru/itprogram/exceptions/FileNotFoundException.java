package ru.itprogram.exceptions;

public class FileNotFoundException extends Exception {
    private static final long serialVersionUID = -2592247998950550001L;

    public FileNotFoundException(String message) {
        super(message);
    }
}
