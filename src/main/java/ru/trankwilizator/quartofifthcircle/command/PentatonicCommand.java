package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.message.CustomScaleCommandMessageProcessor;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

@Component
public class PentatonicCommand extends Command<Notes> {

    protected PentatonicCommand(@Qualifier("pentatonicWrapper") StrWrapper<Notes> wrapper,
                                StrAnswerBuilder strAnswerBuilder) {
        super(new CustomScaleCommandMessageProcessor(wrapper,strAnswerBuilder));
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.pentatonic");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.pentatonic.caption");
    }
}
