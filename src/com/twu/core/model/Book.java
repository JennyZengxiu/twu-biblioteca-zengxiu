package com.twu.core.model;

public class Book {
    private String name;
    private String author;
    private Integer publishedYear;
    private boolean isAccess;

    public Book(String name, String author, Integer publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        isAccess = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean isAccess() {
        return isAccess;
    }

    public void setAccess(boolean access) {
        isAccess = access;
    }
}
