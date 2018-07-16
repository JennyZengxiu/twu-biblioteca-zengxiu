package com.twu.controllers;

import com.twu.commands.InputCommand;
import com.twu.core.Library;

import java.io.IOException;


public class BibliotecaController {
    private InputCommand inputCommand;
    private Library library = new Library();

    public BibliotecaController(InputCommand inputCommand){
        this.inputCommand = inputCommand;
    }

    public void showBookList(){
        System.out.println(String.format("%-40s%-20s%-20s", "Name", "Author", "Year Published"));
        library.getBookList().stream().filter(book -> book.isAccess())
                .forEach(item -> System.out.println(String.format("%-40s%-20s%-20s",item.getName(),item.getAuthor(),item.getPublishedYear())));
    }

    public void checkOutBook(String userName) throws IOException {
        System.out.println("Please input the book name : ");
        String bookName = inputCommand.getInputMessage();
        if (library.checkBookStatus(bookName)) {
            library.changeBookStatus(bookName, userName,false);
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook()throws IOException {
        System.out.println("Please input the book name that you want to return: ");
        String bookName = inputCommand.getInputMessage();
        if (library.checkBook(bookName) ) {
            library.changeBookStatus(bookName,"", true);
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void showMovieList(){
        System.out.println(String.format("%s %s %s %s ", "Name","Year", "Director", "Movie Rating"));
        library.getMovieList().stream().filter(movie -> movie.isAccess())
                .forEach(item -> System.out.println(String.format("%-50s%-20s%-30s%-20s",item.getName(),item.getYear(),item.getDirector(),item.getMovieRating())));
    }

    public void checkoutMovie() throws IOException {
        System.out.println("Please input the movie name : ");
        String movieName = inputCommand.getInputMessage();
        if (library.checkMovieStatus(movieName)) {
            library.changeMovieStatus(movieName, false);
            System.out.println("Thank you! Enjoy the movie.");
        } else {
            System.out.println("That movie is not available.");
        }
    }

    public void quitMessage(){
        System.out.println("see you!");
    }
    public void invalidMenuOption(){
        System.out.println("Select a valid option!");
    }

    public void showCheckoutBookList(){
        System.out.println(String.format("%s          %s", "Book Name", "Lended by"));
        library.getBookList().stream().filter(book -> !book.isAccess())
                .forEach(item->System.out.println(String.format("%s          %s",item.getName(),item.getLendByUser())));
    }
}
