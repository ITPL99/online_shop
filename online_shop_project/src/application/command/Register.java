package application.command;

import application.controller.UserController;
import application.dto.UserDTORegister;
import application.model.Command;

import java.util.Scanner;

public class Register implements Command {

    private final Scanner input;
    private final UserController userController;

    public Register(
            Scanner input,
            UserController userController
    ) {
        this.input = input;
        this.userController = userController;
    }

    @Override
    public void execute() {
        System.out.println("Регистрация пользователя");
        System.out.print("Введите login пользователя: ");
        String username = input.nextLine();
        System.out.print("Введите пароль пользователя: ");
        String password = input.nextLine();
        System.out.println("Подтвердите пароль");
        if(!password.equals(input.nextLine())) {
            System.out.println("Пароли не совпадают");
            return;
        }
        UserDTORegister userDTORegister = new UserDTORegister();
        userDTORegister.setUsername(username);
        userDTORegister.setPassword(password);

        userController.register(userDTORegister);

        System.out.println("Пользователь зарегестрировался " + userController.register(userDTORegister) );

    }
}


