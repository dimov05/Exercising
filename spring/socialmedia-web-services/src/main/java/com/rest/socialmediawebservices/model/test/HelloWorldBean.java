package com.rest.socialmediawebservices.model.test;

public class HelloWorldBean {
    private String text;

    public HelloWorldBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public HelloWorldBean setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "text='" + text + '\'' +
                '}';
    }
}
