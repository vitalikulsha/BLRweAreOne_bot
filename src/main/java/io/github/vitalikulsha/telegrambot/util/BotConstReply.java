package io.github.vitalikulsha.telegrambot.util;

public enum BotConstReply {
    HELLO("Тебя приветствует QuizBot! Сыграем?"),
    START("Выбери из предложенного меню."),
    START_QUEST("Итак, начнем! Первое задание."),
    HINT("Запусти квест, чтобы получить подсказки."),
    HELP("Чат-бот предоставляет возможность пройти увлекательный QUIZ на тему \"Беларусь: мы единый народ\"." +
            " Отвечай по порядку на вопросы чат-бота и проверь свои знания." +
            " Ты всегда можешь обратиться за подсказкой к чат-боту, но только один раз."),
    COMMENT("Правильно! Ты молодец! Вот следующее задание."),
    COMMENT_WIN("Правильно! Это созвездие! Ты выиграл!"),
    UNKNOWN("Эта команда мне неизвестна"),
    N0_RIGHT("Не правильно! Подумай еще!");

    String command;

    public String getCommand() {
        return command;
    }

    BotConstReply(String command) {
        this.command = command;
    }
}
