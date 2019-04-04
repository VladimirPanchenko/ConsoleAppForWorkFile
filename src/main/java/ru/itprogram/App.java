package ru.itprogram;

import ru.itprogram.exceptions.ErrorCommandException;
import ru.itprogram.service.ServiceCommand;
import ru.itprogram.utils.Command;

import java.util.Scanner;

public class App {
    private static final int COUNT_COMMAND = 8;
    private static final String ERROR_COMMAND = "Нет такой команды!";

    public static void main( String[] args ) {
        ServiceCommand serviceCommand = new ServiceCommand();
        String commandLine;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            commandLine = scanner.nextLine();
            String[] stringParse = serviceCommand.parse(commandLine);
            int countError = 0;
            for (Command command : serviceCommand.getCommands()) {
                if (stringParse[0].equals(command.key())) {
                    command.run(stringParse);
                } else {
                    ++countError;
                }
            }
            if (countError == COUNT_COMMAND) {
                try {
                    throw new ErrorCommandException(ERROR_COMMAND);
                } catch (ErrorCommandException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
