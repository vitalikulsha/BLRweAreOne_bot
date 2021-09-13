package io.github.vitalikulsha.telegrambot.util;

public enum BotMutableReply {
    QUESTION_01("Начнем с простого."),
    ANSWER_01("Беларусь"),
    ANSWER_02("Зодиак"),
    ANSWER_03("Созвездие"),
    HINT_STEP01("Подсказка: государство в центре Европы"),
    HINT_STEP02("Подсказка: их 12"),
    HINT_STEP03("Подсказка: скопление звезд");

    String command;

    public String getCommand() {
        return command;
    }

    BotMutableReply(String command) {
        this.command = command;
    }
}
