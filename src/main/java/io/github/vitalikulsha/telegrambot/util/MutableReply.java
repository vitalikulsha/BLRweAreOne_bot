package io.github.vitalikulsha.telegrambot.util;

public enum MutableReply {
    ANSWER01BY("Якуб Колас"),
    ANSWER02BY("Янка Купала"),
    ANSWER03BY("Францыск Скарына"),
    ANSWER03RU("Франциск Скорина"),
    ANSWER04BY("Марк Шагал"),
    ANSWER05BY0("Васiль Быкаў"),
    ANSWER05BY1("Василь Быкаў"),
    ANSWER05BY2("Васiль Быкау"),
    ANSWER05BY3("Василь Быкау"),
    ANSWER05RU("Василь Быков"),
    ANSWER06BY("Дар'я Домрачава"),
    ANSWER06RU("Дарья Домрачева"),
    ANSWER07("Патэльня"),
    ANSWER08("Аловак"),
    ANSWER09BY("Шкарпэткi"),
    ANSWER09RU("Шкарпэтки"),
    ANSWER10("Агрэст"),
    ANSWER11("Твар"),
    ANSWER12("Ажына"),
    ANSWER13BY0("Жодзiна"),
    ANSWER13BY1("Жодзина"),
    ANSWER13RU("Жодино"),
    ANSWER14BY0("Вiцебск"),
    ANSWER14BY1("Вицебск"),
    ANSWER14RU("Витебск"),
    ANSWER15BY0("Магiлёў"),
    ANSWER15BY1("Магiлёу"),
    ANSWER15BY2("Магiлеу"),
    ANSWER15BY3("Магилеу"),
    ANSWER15BY4("Магилёу"),
    ANSWER15RU0("Могилев"),
    ANSWER15RU1("Могилёв"),
    ANSWER16BY("Мiнск"),
    ANSWER16RU("Минск"),
    ANSWER17BY("Брэст>"),
    ANSWER17RU("Брест"),
    ANSWER18BY0("Шклоў"),
    ANSWER18BY1("Шклоу"),
    ANSWER18RU("Шклов");

    String command;

    public String getCommand() {
        return command;
    }

    MutableReply(String command) {
        this.command = command;
    }
}
