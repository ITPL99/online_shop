package application;

import application.service.CommandHendel;

import java.util.Scanner;

public class ApplicationStarter {

    private Scanner input;
    private CommandHendel commandHendel;

    public ApplicationStarter(
            Scanner input,
            CommandHendel commandHendel
    ) {
        this.input = input;
        this.commandHendel = commandHendel;
    }


    public void run(){
        System.out.println("Запуск приложения онлайн магазин");
        while (true){
            System.out.print("введите кодманду: ");
            String userCommand = input.nextLine();
            commandHendel.systemCommandsExecuted(userCommand);
        }
    }
}
