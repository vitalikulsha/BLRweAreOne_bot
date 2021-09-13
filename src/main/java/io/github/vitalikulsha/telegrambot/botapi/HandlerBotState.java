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
        if (messageText.equals(BotMenuCommand.START_QUEST.getCommand())) {
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
            telegramBot.sendPhoto(chatId, BotConstReply.HELLO.getCommand(), "src\\main\\resources\\img\\logo.png");
            replyMessage.setText(BotConstReply.START.getCommand());
            userInfo.add(chatId);
        } else if (messageText.equals("/userinfo")) {
            replyMessage.setText("Количество пользователей " + userInfo.size());
        } else if (messageText.equalsIgnoreCase(BotMenuCommand.START_QUEST.getCommand())) {
            botState = BotState.STEP_01;
            replyMessage.setText(BotConstReply.START_QUEST.getCommand());
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step01.png");
        } else if (messageText.equals(BotMenuCommand.HELP.getCommand())) {
            replyMessage.setText(BotConstReply.HELP.getCommand());
        } else if (messageText.equals(BotMenuCommand.HINT.getCommand())) {
            replyMessage.setText(BotConstReply.HINT.getCommand());
        } else {
            replyMessage.setText(BotConstReply.UNKNOWN.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep01(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_01;
        if (messageText.equalsIgnoreCase(BotMutableReply.ANSWER_01.getCommand())) {
            botState = BotState.STEP_02;
            replyMessage.setText(BotConstReply.COMMENT.getCommand());
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step02.png");
        } else if (messageText.equals(BotMenuCommand.HINT.getCommand())) {
            replyMessage.setText(BotMutableReply.HINT_STEP01.getCommand());
        } else if (messageText.equals(BotMenuCommand.HELP.getCommand())) {
            replyMessage.setText(BotConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(BotConstReply.N0_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep02(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_02;
        if (messageText.equalsIgnoreCase(BotMutableReply.ANSWER_02.getCommand())) {
            botState = BotState.STEP_03;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\step03.png");
            replyMessage.setText(BotConstReply.COMMENT.getCommand());
        } else if (messageText.equals(BotMenuCommand.HINT.getCommand())) {
            replyMessage.setText(BotMutableReply.HINT_STEP02.getCommand());
        } else if (messageText.equals(BotMenuCommand.HELP.getCommand())) {
            replyMessage.setText(BotConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(BotConstReply.N0_RIGHT.getCommand());
        }
        return botState;
    }

    public BotState handlerBotStateStep03(SendMessage replyMessage, String messageText, long chatId) {
        botState = BotState.STEP_03;
        if (messageText.equalsIgnoreCase(BotMutableReply.ANSWER_03.getCommand())) {
            botState = BotState.INITIAL;
            telegramBot.sendPhoto(chatId, "", "src\\main\\resources\\img\\winner.gif");
            replyMessage.setText(BotConstReply.COMMENT_WIN.getCommand());
        } else if (messageText.equals(BotMenuCommand.HINT.getCommand())) {
            replyMessage.setText(BotMutableReply.HINT_STEP03.getCommand());
        } else if (messageText.equals(BotMenuCommand.HELP.getCommand())) {
            replyMessage.setText(BotConstReply.HELP.getCommand());
        } else {
            replyMessage.setText(BotConstReply.N0_RIGHT.getCommand());
        }
        return botState;
    }
}
