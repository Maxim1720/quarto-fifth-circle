package ru.trankwilizator.quartofifthcircle.command.message.handler;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;

public abstract class CommandMessageHandler<T> {

    private final StrWrapper<T> wrapper;
    private String answer;

    protected CommandMessageHandler(StrWrapper<T> wrapper) {
        this.wrapper = wrapper;
    }

    public Message answerToUserMessage(Message message) throws ChordException {
        setAnswerOnQuartoFifthCircleQuery(message.getText());
        Message answerMessage = new Message();
        answerMessage.setText(answer);
        return answerMessage;
    }

    private void setAnswerOnQuartoFifthCircleQuery(String chord){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:
                wrapper.getAsStrings(chord)) {
            stringBuilder.append(s).append("\n");
        }
        answer = stringBuilder.toString();
    }
}
