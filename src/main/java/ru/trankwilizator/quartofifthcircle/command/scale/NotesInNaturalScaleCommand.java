package ru.trankwilizator.quartofifthcircle.command.scale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.Command;
import ru.trankwilizator.quartofifthcircle.message.CommandMessageProcessor;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;

@Component
public class NotesInNaturalScaleCommand extends Command {

    protected NotesInNaturalScaleCommand(@Qualifier("naturalScaleWrapper") StrWrapper<Notes> wrapper,
                                         StrAnswerBuilder strAnswerBuilder) {
        super(new CommandMessageProcessor(wrapper,strAnswerBuilder));
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.natural");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.natural.caption");
    }
}
