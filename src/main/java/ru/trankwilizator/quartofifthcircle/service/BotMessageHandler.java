package ru.trankwilizator.quartofifthcircle.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.logic.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircleWrapper;

@Service
@FieldDefaults( level = AccessLevel.PRIVATE)
public class BotMessageHandler {

    final QuartoFifthCircleWrapper quartoFifthCircle;
    String answer;

    @Autowired
    public BotMessageHandler(QuartoFifthCircleWrapper quartoFifthCircle) {
        this.quartoFifthCircle = quartoFifthCircle;
         answer = "";
    }

    public SendMessage sendMessageAnswer(Message message){
        SendMessage sendMessage = new SendMessage();
        try{
            sendMessage.setText(answer(message).getText());
        }
        catch (ChordException e){
            sendMessage.setText(e.getMessage());
        }
        return sendMessage;

    }

    private Message answer(Message message) throws ChordException{
        validateMessage(message);
        handleChordsInQuartoFifthCircle(message.getText());
        Message answer = new Message();
        answer.setText(this.answer);
        return answer;
    }

    private void handleChordsInQuartoFifthCircle(String chord){
        //validateChord(chord);
        setAnswer(chord);
    }

    private void setAnswer(String chord){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:
                quartoFifthCircle.getChords(chord)) {
            stringBuilder.append(s).append("\n");
        }
        answer = stringBuilder.toString();
    }


    private void validateMessage(Message message){
        if(!message.hasText()) {
            throw new ChordException("Message isn't text");
        }
    }
}
