package org.top.springplanexample.api.message;

import java.time.LocalDateTime;

public class StringMessage {
    private final String message;
    private final LocalDateTime time;

    public StringMessage(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
