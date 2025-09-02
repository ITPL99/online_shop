Проанализировав твой код, я нашел причину. Команда help не работает, потому что она нигде не зарегистрирована в твоей программе.В файле Main.java ты создаешь карту команд commandMap, но добавляешь в нее только одну-единственную команду:JavaMap<String,Command> commandMap = new HashMap<>();
commandMap.put("exit", new Exit()); // <-- Видишь, здесь только 'exit'Твой обработчик команд (CommandHendel) знает только о тех командах, которые лежат в этой карте. Чтобы все заработало, нужно сделать два шага: создать саму команду Help и затем добавить ее в эту карту.Шаг 1: Создай класс для команды HelpТебе нужен класс, который будет реализовывать интерфейс Command и выводить список доступных команд. Логично, чтобы этот класс знал обо всех командах, поэтому мы передадим ему в конструктор нашу карту commandMap.Создай новый файл Help.java (например, в пакете application.command) со следующим содержимым:Javapackage application.command;

import application.model.Command;
import java.util.Map;

public class Help implements Command {

    private final Map<String, Command> commandMap;

    // Конструктор, который принимает карту всех команд
    public Help(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void execute() {
        System.out.println("Доступные команды:");
        // Проходим по всем ключам (именам команд) в карте и выводим их
        for (String commandName : commandMap.keySet()) {
            System.out.println("- " + commandName);
        }
    }
}Шаг 2: Зарегистрируй новую команду в Main.javaТеперь вернись в Main.java и добавь в карту свою новую команду Help.Javaimport application.ApplicationStarter;
import application.command.Exit;
import application.command.Help; // <-- 1. Импортируй новый класс
import application.model.Command;
import application.service.CommandHendel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        Map<String, Command> commandMap = new HashMap<>();
        // Сначала добавляем команды, которые не нужно отображать в help, если такие есть
        commandMap.put("exit", new Exit());

        // 2. Создаем и добавляем команду help, передавая ей саму карту
        commandMap.put("help", new Help(commandMap));


        CommandHendel commandHendel = new CommandHendel(commandMap);

        ApplicationStarter app = new ApplicationStarter(scanner, commandHendel);
        app.run();
    }
}Небольшое улучшениеКстати, имя класса CommandHendel содержит опечатку. В английском языке правильнее будет CommandHandler (Обработчик Команд). Рекомендую переименовать файл и класс для лучшей читаемости кода в будущем.После этих изменений твоя команда help должна заработать как надо и вывести список всех зарегистрированных команд