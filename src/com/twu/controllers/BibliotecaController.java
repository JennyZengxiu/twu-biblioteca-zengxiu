package com.twu.controllers;

import com.twu.commands.InputCommand;
import com.twu.core.model.Book;
import com.twu.core.model.Library;

import java.io.IOException;
import java.util.List;


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

    public void checkOutBook() throws IOException {
        System.out.println("Please input the book name : ");
        String bookName = inputCommand.getInputMessage();
        if (library.checkBookStatus(bookName)) {
            library.changeBookStatus(bookName, false);
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook()throws IOException {
        System.out.println("Please input the book name that you want to return: ");
        String bookName = inputCommand.getInputMessage();
        if (library.checkBook(bookName) ) {
            library.changeBookStatus(bookName, true);
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void quitMessage(){
        System.out.println("see you!");
    }
    public void invalidMenuOption(){
        System.out.println("Select a valid option!");
    }

}
