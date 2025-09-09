import application.ApplicationStarter;
import application.command.Exit;
import application.command.Help;
import application.command.Register;
import application.controller.UserController;
import application.dao.UserDao;
import application.dao.UserDataStorage;
import application.dao.UserRepository;
import application.model.Command;
import application.model.UserEntity;
import application.service.CommandHendel;
import application.service.UserServiceImpl;
import container.ApplicationContext;
import container.Definition;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        List<UserEntity> users= new ArrayList<>();
//        UserDataStorage userData = new UserRepository();
//        UserServiceImpl userService = new UserServiceImpl(userData);
//        UserController controller = new UserController(userService);
//
//
//        Map<String,Command> commandMap = new HashMap<>();
//        commandMap.put("exit", new Exit());
//        commandMap.put("help", new Help());
//        commandMap.put("register", new Register(scanner,controller));
//
//        CommandHendel commandHendel = new CommandHendel(commandMap);
//
//
//        ApplicationStarter app = new ApplicationStarter(scanner, commandHendel);
//        app.run();


       new ApplicationContext(Main.class).run();

        Definition definition = new Definition();

    }
}