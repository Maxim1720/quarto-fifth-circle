package ru.trankwilizator.quartofifthcircle.command.scale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.CustomScaleCommand;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

@Component
public class NotesInMelodicScaleCommand extends CustomScaleCommand<Notes> {

    protected NotesInMelodicScaleCommand(@Qualifier("melodicScaleWrapper") StrWrapper<Notes> wrapper,
                                         StrAnswerBuilder strAnswerBuilder) {
        super(wrapper, strAnswerBuilder);
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("commands")
                .getString("bot.command.scale.melodic");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.melodic.caption");
    }
}
