package ru.itprogram.exceptions;

public class ErrorCommandException extends Exception {
    private static final long serialVersionUID = -2592247998950550001L;

    public ErrorCommandException(String message) {
        super(message);
    }
}
