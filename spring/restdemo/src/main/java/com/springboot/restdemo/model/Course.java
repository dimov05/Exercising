package com.springboot.restdemo.model;

public class Course {
    private Long id;
    private String name;
    private String author;

    public Course() {
    }

    public Course(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Course setAuthor(String author) {
        this.author = author;
        return this;
    }
}
