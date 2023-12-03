package ru.trankwilizator.quartofifthcircle.bot.command.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.bot.command.BotCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.command.GetHarmonicScaleCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.CommandMessageProcessor;

@Component
public class HarmonicScaleBotCommand extends BotCommand {

    @Autowired
    protected HarmonicScaleBotCommand(GetHarmonicScaleCommand command) {
        super(new CommandMessageProcessor(command));
    }

    @Override
    public String getCommandIdentifier() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.harmonic");
    }

    @Override
    public String getDescription() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.scale.harmonic.caption");
    }
}
