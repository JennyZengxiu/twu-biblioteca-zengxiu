package com.twu.core.model;

import com.twu.core.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library(){
        bookList = new ArrayList<Book>(){{
            add(new Book("Head First Java", "Kent Belt", 2003));
            add(new Book("Test-Driven Development", "Kent Belt", 2004));
            add(new Book("Refactoring: Improving the Design", "Martin Fowler", 2010));
            add(new Book("Learn SQL The Hard Way", "Zed A. Shaw", 2011));
            add(new Book("Head First JavaScript", "Eric T. Freeman", 2017));
        }};
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean checkBook(String bookName){
        return bookList.stream().anyMatch(book -> book.getName().equals(bookName));
    }

    public boolean checkBookStatus(String bookName){
        return checkBook(bookName) && bookList.stream().anyMatch(book -> book.isAccess());
    }

    public void changeBookStatus(String bookName,boolean status){
        bookList.stream().filter(book -> book.getName().equals(bookName)).forEach(book -> book.setAccess(status)); }
}
