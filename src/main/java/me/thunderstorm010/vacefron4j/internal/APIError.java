package me.thunderstorm010.vacefron4j.internal;

public class APIError extends RuntimeException {
    public APIError(String message) {
        super(message);
    }
}