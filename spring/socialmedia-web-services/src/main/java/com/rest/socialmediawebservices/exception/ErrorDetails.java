package com.rest.socialmediawebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;

    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ErrorDetails setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ErrorDetails setDetails(String details) {
        this.details = details;
        return this;
    }
}
