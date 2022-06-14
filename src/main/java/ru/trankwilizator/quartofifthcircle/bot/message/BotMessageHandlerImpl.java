package ru.trankwilizator.quartofifthcircle.bot.message;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandlerMediator;
import ru.trankwilizator.quartofifthcircle.command.message.MessageHandler;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.command.message.MessageHandleMode;
import ru.trankwilizator.quartofifthcircle.exception.MessageHandlerException;

@Service
@FieldDefaults( level = AccessLevel.PRIVATE)
public class BotMessageHandlerImpl implements BotMessagesHandler{

    private MessageHandleMode mode;

    @Autowired
    public BotMessageHandlerImpl() {
    }

    public SendMessage getAnswer(Message message) throws MessageHandlerException{
        SendMessage sendMessage = new SendMessage();
        MessageHandler usersMessagesHandler = validateOrGetMessageHandler();

        try {
            validateMessageOnIsText(message);
            Message answerMessage = usersMessagesHandler.answerToUserMessage(message);
            sendMessage.setText(answerMessage.getText());
        } catch (ChordException e) {
            sendMessage.setText(e.getMessage());
        }

        return sendMessage;

    }

    private MessageHandler validateOrGetMessageHandler(){
        MessageHandler messageHandler = CommandMessageHandlerMediator.getMessageHandler();
        if(messageHandler == null)
            throw new MessageHandlerException("Message handler is null");
        return messageHandler;
    }

    private void validateMessageOnIsText(Message message){
        if(!message.hasText()) {
            throw new ChordException("Message isn't text");
        }
    }
    
}
