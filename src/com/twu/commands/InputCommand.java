package com.twu.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputCommand {

    private BufferedReader bufferedReader;
    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public InputCommand(){}

    public String getInputMessage() throws IOException {
        return bufferedReader.readLine();
    }
}
