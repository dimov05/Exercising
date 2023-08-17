package com.rest.socialmediawebservices.model;

public class PersonV1 {
    private String name;
    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }

    public PersonV1 setName(String name) {
        this.name = name;
        return this;
    }
}
