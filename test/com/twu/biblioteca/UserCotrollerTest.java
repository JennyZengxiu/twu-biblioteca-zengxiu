package com.twu.biblioteca;

import com.twu.commands.InputCommand;
import com.twu.controllers.BibliotecaController;
import com.twu.controllers.UserController;
import com.twu.core.exception.OutOfRangeAnswerException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class UserCotrollerTest {
    private UserController userController;
    private ByteArrayOutputStream outContent;
    private InputCommand inputCommand;

    @Before
    public final void before() throws OutOfRangeAnswerException {
        userController = new UserController(inputCommand);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_list_user_information_when_choose_show_user_information() {
        userController.showUserInfomation("zx");
        assertTrue(systemOut().contains("zx       123@qq.com       Wuhan       18112345678"));
    }
}

