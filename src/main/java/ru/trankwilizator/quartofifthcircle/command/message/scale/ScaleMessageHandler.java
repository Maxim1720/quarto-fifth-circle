package ru.trankwilizator.quartofifthcircle.command.message.scale;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.scale.ScaleStringWrapper;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;

@Service
public class ScaleMessageHandler implements CommandMessageHandler {

    ScaleStringWrapper scaleStringWrapper;

    public ScaleMessageHandler(){
        scaleStringWrapper = new ScaleStringWrapper();
    }

    @Override
    public Message answerToUserMessage(Message message) throws ChordException {
        Message message1 = new Message();
        StringBuilder answer = new StringBuilder();
        for (String s:
             scaleStringWrapper.getNotesAsStrings(message.getText())) {
            answer.append(s).append("\n");
        }
        message1.setText(answer.toString());
        return message1;
    }


}
