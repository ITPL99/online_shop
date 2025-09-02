import application.ApplicationStarter;
import application.command.Exit;
import application.command.Help;
import application.model.Command;
import application.service.CommandHendel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String,Command> commandMap = new HashMap<>();
        commandMap.put("exit", new Exit());
        commandMap.put("help", new Help());

        CommandHendel commandHendel = new CommandHendel(commandMap);


        ApplicationStarter app = new ApplicationStarter(scanner, commandHendel);
        app.run();


    }
}