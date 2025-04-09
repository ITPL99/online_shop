import application.ApplicationStarter;
import application.model.Command;
import application.service.CommandHendel;
import application.command.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Command> systemCommands = new HashMap<>();
        systemCommands.put("exit", new Exit());
        new ApplicationStarter(
                new Scanner(System.in),
                new CommandHendel(systemCommands)
        ).run();
    }
}