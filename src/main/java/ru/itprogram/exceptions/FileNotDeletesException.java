package ru.itprogram.exceptions;

public class FileNotDeletesException extends Exception {
    private static final long serialVersionUID = -2592247998950550001L;

    public FileNotDeletesException(String message) {
        super(message);
    }
}
