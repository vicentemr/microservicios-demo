package com.example.demo01;

public class Greeting {
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }
}
