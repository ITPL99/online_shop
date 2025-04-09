import application.ApplicationStarter;
import application.model.Command;
import application.service.CommandHendel;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new ApplicationStarter(
                new Scanner(System.in),
                new CommandHendel(new HashMap<>())
        ).run();
    }
}