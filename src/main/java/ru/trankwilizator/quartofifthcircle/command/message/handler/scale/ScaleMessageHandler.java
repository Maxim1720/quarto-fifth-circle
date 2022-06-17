package ru.trankwilizator.quartofifthcircle.command.message.handler.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;

@Service
public class ScaleMessageHandler extends ru.trankwilizator.quartofifthcircle.command.message.handler.CommandMessageHandler<Notes>
        implements CommandMessageHandler {

    @Autowired
    protected ScaleMessageHandler(StrWrapper<Notes> wrapper) {
        super(wrapper);
    }
}
