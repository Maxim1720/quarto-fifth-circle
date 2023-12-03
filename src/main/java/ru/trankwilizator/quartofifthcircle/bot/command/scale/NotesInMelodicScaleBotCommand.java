package ru.trankwilizator.quartofifthcircle.bot.command.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.bot.command.BotCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.command.GetMelodicScaleCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.ScaleCommandMessageProcessor;

@Component
public class NotesInMelodicScaleBotCommand extends BotCommand {

    @Autowired
    protected NotesInMelodicScaleBotCommand(GetMelodicScaleCommand command) {
        super(new ScaleCommandMessageProcessor(command));
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.melodic");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.melodic.caption");
    }
}
