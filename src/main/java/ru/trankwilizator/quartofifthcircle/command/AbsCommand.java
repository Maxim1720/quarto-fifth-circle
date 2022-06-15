package ru.trankwilizator.quartofifthcircle.command;

import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandlerMediator;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;

import java.util.Arrays;

public abstract class AbsCommand implements IBotCommand {



    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        try {
            LoggerFactory.getLogger(System.Logger.class).info(Arrays.toString(strings));
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChat().getId().toString());
            sendMessage.setText(getAnswerOnCommand());
            absSender.execute(sendMessage);
            setMessageHandleMode();
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);//CommandException("Incorrect command");
        }
    }


    private void setMessageHandleMode(){
        CommandMessageHandlerMediator.setMessageHandler(getCommandMessageHandler());
    }
    protected abstract String getAnswerOnCommand();

    protected abstract MessageHandler getCommandMessageHandler();
}
