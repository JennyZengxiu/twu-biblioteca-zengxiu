package com.twu.biblioteca;

import com.twu.commands.InputCommand;
import com.twu.controllers.BibliotecaController;
import com.twu.controllers.UserController;

import java.io.IOException;

public class BibliotecaApp {
    private static final String MAIN_MENU = "1.List Books\n" +
            "2.Checkout Books\n" +
            "3.Return Books\n" +
            "4.List Movies\n" +
            "5.Checkout Movies\n" +
            "6.User information\n" +
            "7.Quit\n" +
            "Please take a choice: ";

    private InputCommand inputCommand = new InputCommand();
    private BibliotecaController bibliotecaController = new BibliotecaController(inputCommand);
    private UserController userController = new UserController(inputCommand);

    public void showWelcomeMessage() {
        System.out.println("------Welcome to Biblioteca!------");
    }

    public void dividLine() {
        System.out.println("=======================================================================================");
    }

    public void showMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void mainMenu(String userName) throws IOException {
        boolean access = true;
        showWelcomeMessage();
        while (access) {
            dividLine();
            showMainMenu();
            switch (inputCommand.getInputMessage()) {
                case "1":
                    bibliotecaController.showBookList();
                    break;
                case "2":
                    bibliotecaController.checkOutBook(userName);
                    break;
                case "3":
                    bibliotecaController.returnBook();
                    break;
                case "4":
                    bibliotecaController.showMovieList();
                    break;
                case "5":
                    bibliotecaController.checkoutMovie();
                    break;
                case "6":
                    userController.showUserInfomation(userName);
                    break;
                case "7":
                    bibliotecaController.quitMessage();
                    access = false;
                    break;
                default:
                    bibliotecaController.invalidMenuOption();
                    break;
            }
        }
    }

    public void librarianMenu() {
        System.out.println("1.Show checkout List\n" +
                "2.User information\n" +
                "3.Quit\n" +
                "Please take a choice: ");
    }

    public void librarianLogin(String librarianName) throws IOException {
        librarianMenu();
        boolean status = true;
        while (status) {
            switch (inputCommand.getInputMessage()) {
                case "1":
                    bibliotecaController.showCheckoutBookList();
                    dividLine();
                    librarianMenu();
                    break;
                case "2":
                    userController.showUserInfomation(librarianName);
                    dividLine();
                    librarianMenu();
                    break;
                case "3":
                    bibliotecaController.quitMessage();
                    status = false;
                    break;
                default:
                    bibliotecaController.invalidMenuOption();
                    break;
            }
        }
    }

    public void loginMenu() {
        System.out.println("1.Login as a customer\n" +
                "2.Login as a librarian\n" +
                "3.quit\n" +
                "Please take a choice: ");
    }

    public void login() throws IOException {
        loginMenu();
        boolean status = true;
        while (status) {
            switch (inputCommand.getInputMessage()) {
                case "1":
                    mainMenu(userController.verifyLogin());
                    dividLine();
                    loginMenu();
                    break;
                case "2":
                    librarianLogin(userController.verifyLogin());
                    dividLine();
                    loginMenu();
                    break;
                case "3":
                    bibliotecaController.quitMessage();
                    status = false;
                    break;
                default:
                    bibliotecaController.invalidMenuOption();
                    break;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.login();
    }
}
