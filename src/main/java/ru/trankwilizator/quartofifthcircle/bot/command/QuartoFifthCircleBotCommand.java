package ru.trankwilizator.quartofifthcircle.bot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.message.processor.command.GetQuartoFifthCircleCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.CommandMessageProcessor;

@Component
public class QuartoFifthCircleBotCommand extends BotCommand {
    @Autowired
    protected QuartoFifthCircleBotCommand(GetQuartoFifthCircleCommand command){
        super(new CommandMessageProcessor(command));
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
