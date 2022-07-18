package ru.trankwilizator.quartofifthcircle.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.trankwilizator.quartofifthcircle.message.MessageProcessor;

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
            sendMessage = new SendMessage(message.getChat().getId().toString(),
                    e.getMessage());
            tryExecuteSendMessage(absSender,sendMessage);
        }
    }

    private void sendAnswers(String[] strings, Message message, AbsSender sender){
        for (String chordText :
                strings) {
            SendMessage sendMessage;
            try {
                sendMessage = new SendMessage(message.getChat().getId().toString(),
                        strAnswerBuilder.build(getResultStrings(chordText)));
            }
            catch (ChordException e){
                sendMessage = new SendMessage(message.getChat().getId().toString(),
                        e.getMessage());
            }
            tryExecuteSendMessage(sender,sendMessage);
        }
    }

    protected StrWrapper<T> wrapper(){
        return wrapper;
    }

    protected String[] getResultStrings(String tonality){
        return wrapper().getAsStrings(tonality);
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
