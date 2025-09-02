package application.command;

import application.model.Command;

public class Help implements Command {

    @Override
    public void execute() {
        System.out.println("exit - команда выхода из программы");
        System.out.println("help - команда вывода списка команд системы");
    }
}
