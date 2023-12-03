package ru.trankwilizator.quartofifthcircle.bot.command.scale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.bot.command.BotCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.CommandMessageProcessor;
import ru.trankwilizator.quartofifthcircle.message.processor.command.Command;

@Component
public class NotesInNaturalScaleBotCommand extends BotCommand {

    protected NotesInNaturalScaleBotCommand(@Qualifier("getNaturalScaleCommand") Command command) {
        super(new CommandMessageProcessor(command));
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
