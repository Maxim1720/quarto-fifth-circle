package ru.trankwilizator.quartofifthcircle.bot.command.simple;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.helpCommand.HelpCommand;
import ru.trankwilizator.quartofifthcircle.bot.command.BotCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.simple.SimpleMessageProcessor;

@Component
public class HelpBotCommand extends BotCommand {
    protected HelpBotCommand() {
        super(new SimpleMessageProcessor(MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.command.help"))
        );
    }

    @Override
    public String getCommandIdentifier() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "помощь";
    }
}
