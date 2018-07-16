package com.twu.controllers;

import com.twu.commands.InputCommand;
import com.twu.core.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserController {
    public static List<User> userList = new ArrayList<User>() {
        {
            add(new User("zx","123456", "123@qq.com", "Wuhan", "18112345678"));
            add(new User("ay", "456789","456@qq.com", "Xi'an", "18122345678"));
            add(new User("xx", "123789","789@qq.com", "Beijing", "18133455678"));
            add(new User("librarian", "123","a@qq.com", "Beijing", "18168686688"));
        }
    };

    private InputCommand inputCommand;
    public UserController(InputCommand inputCommand){
        this.inputCommand = inputCommand;
    }

    public String verifyLogin() throws IOException {
        while (true){
            System.out.println("Please input you userName:\n");
            String userName = inputCommand.getInputMessage();
            System.out.println("Please input you password:\n");
            String password = inputCommand.getInputMessage();
            if (checkUserName(userName,password)) {
                System.out.println("Login Successful！");
                return userName;
            }
            else {
                System.out.println("The userName is not exist or the password is wrong!");
            }
        }
    }

    public boolean checkUserName(String userName, String password) {
        return userList.stream().anyMatch(user -> user.getUserName().equals(userName)&&user.getPassword().equals(password));
    }

    public void showUserInfomation(String userName){
        System.out.println(String.format("%s      %s       %s       %s", "Name", "Email", "Address","PhoneNumber"));
        userList.stream().filter(user -> user.getUserName().equals(userName))
                .forEach(item -> System.out.println(String.format("%s       %s       %s       %s", item.getUserName(), item.getEmail(), item.getAddress(), item.getPhoneNumber())));
    }

}
