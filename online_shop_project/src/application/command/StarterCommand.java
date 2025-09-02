package application.command;

import application.ApplicationStarter;
import application.controller.UserController;
import application.dao.UserDao;
import application.model.Command;
import application.service.CommandHendel;
import application.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StarterCommand {
    private UserController userController;
    private UserServiceImpl userService;
    private Map<String, Command> commands;
    private UserDao userDao;
    private Scanner scanner;
    private CommandHendel commandHendel;

    public StarterCommand() {

        scanner = new Scanner(System.in);
        userDao = new UserDao();
        userService = new UserServiceImpl(userDao);
        userController = new UserController(userService);
        CommandHandler();
        commandHendel = new CommandHendel(commands);    }

    public StarterCommand applicationStarter(){
        ApplicationStarter app = new ApplicationStarter(scanner,commandHendel);
        app.run();
        return this;

    }
    private void CommandHandler(){
        commands = new HashMap<>();
        commands.put("exit", new Exit());
        commands.put("help", new Help());
        commands.put("register", new Register(scanner,userController));
    }


}
