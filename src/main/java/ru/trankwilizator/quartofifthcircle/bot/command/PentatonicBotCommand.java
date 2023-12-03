package ru.trankwilizator.quartofifthcircle.bot.command;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.message.processor.command.GetPentatonicCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.CommandMessageProcessor;

@Component
public class PentatonicBotCommand extends BotCommand {
    protected PentatonicBotCommand(GetPentatonicCommand command) {
        super(new CommandMessageProcessor(command));
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
