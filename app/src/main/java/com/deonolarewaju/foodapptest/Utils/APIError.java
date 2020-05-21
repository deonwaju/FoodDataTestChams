package com.deonolarewaju.foodapptest.Utils;

public class APIError {
    private boolean status;
    private String message;
    private Object data;

    public APIError(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
