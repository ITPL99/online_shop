import application.ApplicationStarter;
import application.command.Exit;
import application.command.Help;
import application.command.Register;
import application.command.StarterCommand;
import application.controller.UserController;
import application.dao.UserDao;
import application.model.Command;
import application.service.CommandHendel;
import application.service.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StarterCommand starter = new StarterCommand().applicationStarter();

    }
}