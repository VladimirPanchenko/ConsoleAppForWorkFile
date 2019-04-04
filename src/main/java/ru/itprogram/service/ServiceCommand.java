package ru.itprogram.service;

import ru.itprogram.utils.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceCommand {
    private List<Command> commands;

    public ServiceCommand() {
        commands = new ArrayList<>();
        commands.add(new HelpCommand());
        commands.add(new FileCreateCommand());
        commands.add(new FileWriteCommand());
        commands.add(new FileCopyCommand());
        commands.add(new FileDeleteCommand());
        commands.add(new FileZipCommand());
        commands.add(new FileReadCommand());
        commands.add(new ExitCommand());
    }

    public String[] parse(String command) {
        return command.split(" ");
    }

    public List<Command> getCommands() {
        return commands;
    }
}
