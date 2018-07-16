package com.twu.biblioteca;


import com.twu.core.exception.OutOfRangeAnswerException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public final void before() throws OutOfRangeAnswerException{
        System.setOut(new PrintStream(outContent));
        bibliotecaApp = new BibliotecaApp();
    }

    private String systemOut(){
        return outContent.toString();
    }

    @Test
    public void should_show_welcome_message_when_start_application(){
        bibliotecaApp.showWelcomeMessage();
        assertTrue(systemOut().startsWith("------Welcome to Biblioteca!------"));
    }

    @Test
    public void should_list_main_menu_when_start_application(){
        bibliotecaApp.showMainMenu();
        assertTrue(systemOut().contains("1.List Books\n" +
                "2.Checkout Books\n" +
                "3.Return Books\n" +
                "4.Quit\n" +
                "Please take a choice: "));
    }

}
