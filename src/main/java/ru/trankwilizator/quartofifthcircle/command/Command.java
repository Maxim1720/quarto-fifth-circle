package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;

public abstract class Command<T> implements IBotCommand {
    private final StrWrapper<T> wrapper;
    private final StrAnswerBuilder strAnswerBuilder;

    protected Command(StrWrapper<T> wrapper,
                      StrAnswerBuilder strAnswerBuilder) {
        this.wrapper = wrapper;
        this.strAnswerBuilder = strAnswerBuilder;
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        SendMessage sendMessage;
        try {
            checkIsEmptyStrings(strings);
            sendAnswers(strings,message,absSender);
        }
        catch (ChordException e){
            sendMessage = new SendMessage(message.getChat().getId().toString(), e.getMessage());
            sendMessage.setReplyToMessageId(message.getMessageId());
            tryExecuteSendMessage(absSender,sendMessage);
        }
    }

    private void sendAnswers(String[] strings, Message message, AbsSender sender){
        for (String chordText : strings) {
            SendMessage sendMessage;
            try {
                sendMessage = new SendMessage(message.getChat().getId().toString(),
                        strAnswerBuilder.build(wrapper.getAsStrings(chordText)));
                sendMessage.setReplyToMessageId(message.getMessageId());
            }
            catch (ChordException e){
                sendMessage = new SendMessage(message.getChat().getId().toString(), e.getMessage());
            }
            tryExecuteSendMessage(sender,sendMessage);
        }
    }

    private void checkIsEmptyStrings(String[] strings){
        if(strings.length == 0){
            throw new ChordException(MessageSourceResourceBundle
                    .getBundle("messages")
                    .getString("bot.chord.error.empty"));
        }
    }
    private void tryExecuteSendMessage(AbsSender sender, SendMessage sendMessage){
        try {
            sender.execute(sendMessage);
        }
        catch (TelegramApiException e){
            throw new RuntimeException();
        }
    }


}
