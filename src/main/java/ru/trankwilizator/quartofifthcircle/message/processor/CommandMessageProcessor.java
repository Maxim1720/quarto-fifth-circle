package ru.trankwilizator.quartofifthcircle.message.processor;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.exception.TonalityException;
import ru.trankwilizator.quartofifthcircle.message.processor.command.Command;


public class CommandMessageProcessor implements MessageProcessor {

    protected Command command;
    public CommandMessageProcessor(Command command) {
        this.command = command;
    }
    @Override
    public final void processMessage(AbsSender absSender, Message message, String[] strings) {
        try {
            checkIsEmptyStrings(strings);
            sendAnswers(strings,message,absSender);
        }
        catch (TonalityException e){
            tryExecuteSendMessage(absSender,
                    new SendMessage(message
                            .getChat()
                            .getId().toString(),
                            e.getMessage())
            );
        }
    }

    private void checkIsEmptyStrings(String[] strings){
        if(strings.length == 0){
            throw new TonalityException(MessageSourceResourceBundle
                    .getBundle("messages")
                    .getString("bot.tonality.error.empty"));
        }
    }
    private void sendAnswers(String[] strings, Message message, AbsSender sender){
        for (String chordText :
                strings) {
            tryExecuteSendMessage(sender,
                    tryGetResultSendMessage(message
                                    .getChat()
                                    .getId().toString(),
                            chordText));
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
    private SendMessage tryGetResultSendMessage(String chatId, String key){
        SendMessage sendMessage;
        try {
            sendMessage = new SendMessage(chatId, answer(key));
        }
        catch (TonalityException e){
            sendMessage = new SendMessage(chatId,
                    e.getMessage());
        }
        return sendMessage;
    }

    protected String answer(String key){
        return command.execute(key);
    }
}
