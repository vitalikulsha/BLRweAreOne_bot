package io.github.vitalikulsha.telegrambot.botapi;

import io.github.vitalikulsha.telegrambot.service.TelegramBot;
import io.github.vitalikulsha.telegrambot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashSet;
import java.util.Set;

@Component
public class HandlerBotState {
    private BotState botState;
    private Set<Long> userInfo = new HashSet<>();
    @Autowired
    TelegramBot telegramBot;


    public BotState initBotState(String messageText) {
        if (messageText.equals(MenuCommand.START_QUEST.getCommand())) {
            botState = BotState.STEP_01;
        } else if (messageText.equals("/start")) {
            botState = BotState.INITIAL;
        } else {
            botState = BotState.INITIAL;
        }
        return botState;
    }

    public BotState handlerBotStateInitial(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.INITIAL;
        if (messageText.equals("/start")) {
            telegramBot.sendPhoto(chatId, ConstReply.HELLO.getCommand(), "src\\main\\resources\\img\\logo.png");
            replyMessage.setText(ConstReply.START.getCommand());
            userInfo.add(chatId);
        } else if (messageText.equals("/userinfo")) {
            replyMessage.setText("Колькасць карыстальнікаў " + userInfo.size());
        } else if (messageText.equalsIgnoreCase(MenuCommand.START_QUEST.getCommand())) {
            botState = BotState.STEP_01;
            replyMessage.setText(ConstReply.START_QUEST.getCommand());
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step01.jpg");
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(ConstReply.HINT.getCommand());
        } else {
            replyMessage.setText(ConstReply.UNKNOWN.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep01(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_01;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER01BY.getCommand())) {
            botState = BotState.STEP_02;
            replyMessage.setText(ConstReply.COMMENT.getCommand());
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step02.jpg");
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT01.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep02(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_02;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER02BY.getCommand())) {
            botState = BotState.STEP_03;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step03.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT02.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep03(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_03;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER03BY.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER03RU.getCommand())) {
            botState = BotState.STEP_04;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step04.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT03.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep04(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_04;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER04BY.getCommand())) {
            botState = BotState.STEP_05;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step05.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT04.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep05(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_05;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER05BY0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY1.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY2.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY3.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05RU.getCommand())) {
            botState = BotState.STEP_06;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step06.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT05.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep06(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_06;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER06BY.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER06RU.getCommand())) {
            botState = BotState.STEP_07;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step07.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT06.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep07(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_07;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER07.getCommand())) {
            botState = BotState.STEP_08;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step08.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT07.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep08(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_08;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER08.getCommand())) {
            botState = BotState.STEP_09;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step09.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT08.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep09(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_09;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER09BY.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER09RU.getCommand())) {
            botState = BotState.STEP_10;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step10.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT09.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep10(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_10;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER10.getCommand())) {
            botState = BotState.STEP_11;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step11.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT10.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep11(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_11;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER11.getCommand())) {
            botState = BotState.STEP_12;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step12.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT11.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep12(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_12;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER12.getCommand())) {
            botState = BotState.STEP_13;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step13.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT12.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep13(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_13;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER13BY0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER13BY1.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER13RU.getCommand())) {
            botState = BotState.STEP_14;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step14.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT13.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep14(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_14;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER14BY0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER14BY1.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER14RU.getCommand())) {
            botState = BotState.STEP_15;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step15.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT14.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep15(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_15;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER15BY0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15BY1.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15BY2.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15BY3.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15BY4.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15RU0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER15RU1.getCommand())) {
            botState = BotState.STEP_16;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step16.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT15.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep16(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_16;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER16BY.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER16RU.getCommand())) {
            botState = BotState.STEP_17;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step17.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT16.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep17(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_17;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER17BY.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER17RU.getCommand())) {
            botState = BotState.STEP_18;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step18.jpg");
            replyMessage.setText(ConstReply.COMMENT.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT17.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep18(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_18;
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER18BY0.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER18BY1.getCommand()) ||
                messageText.equalsIgnoreCase(MutableReply.ANSWER18RU.getCommand())) {
            botState = BotState.INITIAL;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\winner.gif");
            replyMessage.setText(ConstReply.COMMENT_WIN.getCommand());
        } else if (messageText.equals(MenuCommand.HINT.getCommand())) {
            replyMessage.setText(MutableHint.HINT18.getCommand());
        } else if (messageText.equals(MenuCommand.HELP.getCommand())) {
            replyMessage.setText(ConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(ConstReply.NO_RIGHT.getCommand());
        }
        return botState;
    }
}
