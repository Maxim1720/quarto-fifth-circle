package ru.trankwilizator.quartofifthcircle.message;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.IStrWrapper;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;


public class CommandMessageProcessor implements MessageProcessor{

    private final IStrWrapper wrapper;
    private final StrAnswerBuilder strAnswerBuilder;

    public CommandMessageProcessor(IStrWrapper wrapper,
                                      StrAnswerBuilder strAnswerBuilder) {
        this.wrapper = wrapper;
        this.strAnswerBuilder = strAnswerBuilder;
    }

    protected IStrWrapper wrapper(){
        return wrapper;
    }

    protected String[] getResultStrings(String tonality){
        return wrapper().getAsStrings(tonality);
    }

    public void processMessage(AbsSender absSender, Message message, String[] strings){
        try {
            checkIsEmptyStrings(strings);
            sendAnswers(strings,message,absSender);
        }
        catch (ChordException e){
            tryExecuteSendMessage(absSender,
                    new SendMessage(message
                            .getChat()
                            .getId().toString(),
                            e.getMessage())
            );
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

    protected IStrWrapper wrapper(){
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
