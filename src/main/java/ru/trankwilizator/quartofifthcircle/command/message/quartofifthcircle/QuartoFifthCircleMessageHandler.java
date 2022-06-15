package ru.trankwilizator.quartofifthcircle.command.message.quartofifthcircle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircleWrapper;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;

@Service
public class QuartoFifthCircleMessageHandler implements CommandMessageHandler {
    private final QuartoFifthCircleWrapper quartoFifthCircle;
    private String answer;

    @Autowired
    public QuartoFifthCircleMessageHandler() {
        this.quartoFifthCircle = new QuartoFifthCircleWrapper();
    }

    public Message answerToUserMessage(Message message) throws ChordException {
        setAnswerOnQuartoFifthCircleQuery(message.getText());
        Message answer = new Message();
        answer.setText(this.answer);
        return answer;
    }

    private void setAnswerOnQuartoFifthCircleQuery(String chord){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:
                quartoFifthCircle.getChords(chord)) {
            stringBuilder.append(s).append("\n");
        }
        answer = stringBuilder.toString();
    }


}
