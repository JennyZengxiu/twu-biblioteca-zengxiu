package com.twu.biblioteca;

import com.twu.commands.InputCommand;
import com.twu.controllers.BibliotecaController;
import com.twu.core.Library;
import com.twu.core.exception.OutOfRangeAnswerException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaControllerTest {
    private BibliotecaController bibliotecaController;
    private ByteArrayOutputStream outContent;
    private InputCommand inputCommand;
    @Before
    public final void before()throws OutOfRangeAnswerException {
        inputCommand = mock(InputCommand.class);
        bibliotecaController = new BibliotecaController(inputCommand);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut(){
        return outContent.toString();
    }

    @Test
    public void should_show_message_when_checkout_a_available_book() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Head First Java");
        bibliotecaController.checkOutBook("zx");
        assertTrue(systemOut().contains("Thank you! Enjoy the book."));
    }

    @Test
    public void should_show_message_when_checkout_a_unavailable_book() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Java");
        bibliotecaController.checkOutBook("zx");
        assertTrue(systemOut().contains("That book is not available."));
    }

    @Test
    public void should_show_message_when_checkout_a_available_movie() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Jurassic World：Fallen Kingdom");
        bibliotecaController.checkoutMovie();
        assertTrue(systemOut().contains("Thank you! Enjoy the movie."));
    }

    @Test
    public void should_show_message_when_checkout_a_unavailable_movie() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("movie");
        bibliotecaController.checkoutMovie();
        assertTrue(systemOut().contains("That movie is not available."));
    }

    @Test
    public void should_show_message_when_successful_return() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Head First Java");
        bibliotecaController.returnBook();
        assertTrue(systemOut().contains("Thank you for returning the book."));
    }

    @Test
    public void should_show_message_when_unsuccessful_return() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Java");
        bibliotecaController.returnBook();
        assertTrue(systemOut().contains("That is not a valid book to return."));
    }

    @Test
    public void should_show_message_when_make_invalid_menu_option(){
        bibliotecaController.invalidMenuOption();
        assertTrue(systemOut().contains("Select a valid option!"));
    }

    @Test
    public void should_show_meaasge_when_choose_quit(){
        bibliotecaController.quitMessage();
        assertTrue(systemOut().contains("see you!"));
    }

    @Test
    public void should_show_checkout_boook_list_when_librarian_check_lend_list() throws IOException {
        when(inputCommand.getInputMessage()).thenReturn("Head First Java");
        bibliotecaController.checkOutBook("zx");
        bibliotecaController.showCheckoutBookList();
        assertTrue(systemOut().contains("Head First Java          zx"));
    }
}
