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
        if (messageText.equalsIgnoreCase(MutableReply.ANSWER05BY0.getCommand())||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY1.getCommand())||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY2.getCommand())||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05BY3.getCommand())||
                messageText.equalsIgnoreCase(MutableReply.ANSWER05RU.getCommand())) {
            botState = BotState.STEP_06;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step06.jpg");
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
}
