package io.github.vitalikulsha.telegrambot.util;

public enum MenuCommand {
    START_QUEST("Пачаць Quiz"),
    HINT("Падказка"),
    HELP("Даведка");
    String command;

    public String getCommand() {
        return command;
    }

    MenuCommand(String command) {
        this.command = command;
    }
}
