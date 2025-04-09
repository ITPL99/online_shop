package application.command;
import application.model.*;
public class exit implements Command {
    @Override
    public void execute() {System.exit(0);}

    @Override
    public String toString() {return "exit - завершилась работа программы";}
}
