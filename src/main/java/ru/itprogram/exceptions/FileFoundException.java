package ru.itprogram.exceptions;

public class FileFoundException extends Exception {
    private static final long serialVersionUID = -2592247998950550001L;

    public FileFoundException(String message) {
        super(message);
    }
}
