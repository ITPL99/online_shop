package application.service;

import application.model.Command;

import java.util.Map;

public class CommandHendel {
    private Map<String, Command> systemCommands;

    public CommandHendel(Map<String, Command> systemCommands) {
        this.systemCommands = systemCommands;
    }


    public void systemCommandsExecuted(String userCommand){
        if(systemCommands.containsKey(userCommand)){
            Command command = systemCommands.get(userCommand);
            command.execute();
        }else {
            System.out.println("Такой команды нет в системе");
        }
    }
}
