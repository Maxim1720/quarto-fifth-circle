package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.strings.StrAnswerBuilder;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;

@Component
public class NotesInNaturalScaleCommand extends Command<Notes>{

    protected NotesInNaturalScaleCommand(@Qualifier("notesWrapper") StrWrapper<Notes> wrapper,
                                         StrAnswerBuilder strAnswerBuilder) {
        super(wrapper, strAnswerBuilder);
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.notesInScale.natural");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.notesInScale.natural.caption");
    }
}
