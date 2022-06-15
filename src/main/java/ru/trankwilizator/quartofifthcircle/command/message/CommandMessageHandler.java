package ru.trankwilizator.quartofifthcircle.command.message;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;

@Component
public interface CommandMessageHandler {

    Message answerToUserMessage(Message message) throws ChordException;

}
