package com.twu.core;

import com.twu.core.model.Book;
import com.twu.core.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Movie> movieList;

    public Library(){
        bookList = new ArrayList<Book>(){{
            add(new Book("Head First Java", "Kent Belt", 2003));
            add(new Book("Test-Driven Development", "Kent Belt", 2004));
            add(new Book("Refactoring: Improving the Design", "Martin Fowler", 2010));
            add(new Book("Learn SQL The Hard Way", "Zed A. Shaw", 2011));
            add(new Book("Head First JavaScript", "Eric T. Freeman", 2017));
        }};
        movieList = new ArrayList<Movie>() {{
            add(new Movie("Jurassic World：Fallen Kingdom", 2018, "Juan Antonio Bayona", "6.9"));
            add(new Movie("Deadpool", 2018, "David Leitch", "8.0"));
            add(new Movie("Annihilation", 2016, "Alex Garland", "7.2"));
            add(new Movie("Blumhouse", 2018, "Jordan Peele", "7.6"));
            add(new Movie("The Conjuring 2", 2016, "James Wan", "7.6"));

        }};
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public boolean checkBook(String bookName){
        return bookList.stream().anyMatch(book -> book.getName().equals(bookName));
    }

    public boolean checkBookStatus(String bookName){
        return checkBook(bookName) && bookList.stream().anyMatch(book -> book.isAccess());
    }

    public void changeBookStatus(String bookName,String userName,boolean status){
        bookList.stream().filter(book -> book.getName().equals(bookName))
                .forEach(book -> {
                    book.setAccess(status);
                    book.setLendByUser(userName);}
                    );
    }

    public boolean checkMovie(String movieName){
        return movieList.stream().anyMatch(movie -> movie.getName().equals(movieName));
    }

    public boolean checkMovieStatus(String movieName){
        return checkMovie(movieName) && movieList.stream().anyMatch(movie -> movie.isAccess());
    }

    public void changeMovieStatus(String movieName,boolean status){
        movieList.stream().filter(movie -> movie.getName().equals(movieName)).forEach(movie -> movie.setAccess(status));
    }

}
