package application.service;

import application.model.Command;
import container.Autowired;
import container.Component;

import java.util.Map;


//@Component
public class CommandHendel {
    private Map<String, Command> systemCommands;

//    @Autowired
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
