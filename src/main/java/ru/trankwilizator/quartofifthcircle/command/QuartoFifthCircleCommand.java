package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

@Component
public class QuartoFifthCircleCommand extends Command<Chord> {
    @Autowired
    protected QuartoFifthCircleCommand(StrWrapper<Chord> wrapper, StrAnswerBuilder strAnswerBuilder) {
        super(wrapper, strAnswerBuilder);
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle.getBundle("messages").getString("bot.command.quartoFifthCircle");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle.getBundle("messages").getString("bot.command.quartoFifthCircle.caption");
    }

}
