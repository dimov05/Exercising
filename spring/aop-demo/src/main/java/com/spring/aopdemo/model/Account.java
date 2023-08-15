package com.spring.aopdemo.model;

public class Account {
    private String name;
    private String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public Account setLevel(String level) {
        this.level = level;
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
