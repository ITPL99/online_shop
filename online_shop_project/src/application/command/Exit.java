package application.command;
import application.model.Command;
public class Exit implements Command {
    @Override
    public void execute() {System.exit(0);}

}
