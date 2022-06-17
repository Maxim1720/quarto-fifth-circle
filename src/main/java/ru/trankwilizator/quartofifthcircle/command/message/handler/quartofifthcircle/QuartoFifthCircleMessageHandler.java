package ru.trankwilizator.quartofifthcircle.command.message.handler.quartofifthcircle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

@Service
public class QuartoFifthCircleMessageHandler extends ru.trankwilizator.quartofifthcircle
        .command.message.handler.CommandMessageHandler<Chord>
        implements CommandMessageHandler {

    @Autowired
    protected QuartoFifthCircleMessageHandler(StrWrapper<Chord> wrapper) {
        super(wrapper);
    }
}
