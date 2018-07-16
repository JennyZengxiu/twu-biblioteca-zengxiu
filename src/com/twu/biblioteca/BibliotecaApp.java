package com.twu.biblioteca;

import com.twu.commands.InputCommand;
import com.twu.controllers.BibliotecaController;

import java.io.IOException;

public class BibliotecaApp {
    private static final String MAIN_MENU = "1.List Books\n" +
            "2.Checkout Books\n" +
            "3.Return Books\n" +
            "4.Quit\n" +
            "Please take a choice: ";

    private InputCommand inputCommand = new InputCommand();
    private BibliotecaController bibliotecaController = new BibliotecaController(inputCommand);

    public void showWelcomeMessage(){
        System.out.println("------Welcome to Biblioteca!------");
    }

    public void showMainMenu(){
        System.out.println(MAIN_MENU);
    }

    public void mainMenu() throws IOException {
        boolean access = true;
        showWelcomeMessage();
        while (access) {
            showMainMenu();
            switch (inputCommand.getInputMessage()) {
                case "1":
                    bibliotecaController.showBookList();
                    break;
                case "2":
                    bibliotecaController.checkOutBook();
                    break;
                case "3":
                    bibliotecaController.returnBook();
                    break;
                case "4":
                    bibliotecaController.quitMessage();
                    access = false;
                    break;
                default:
                    bibliotecaController.invalidMenuOption();
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
       BibliotecaApp bibliotecaApp = new BibliotecaApp();
       bibliotecaApp.mainMenu();
    }
}
