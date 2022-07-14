package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.trankwilizator.quartofifthcircle.command.strings.StrAnswerBuilder;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircle;

@Component
public class QuartoFifthCircleCommand extends Command<Chord> {
    @Autowired
    protected QuartoFifthCircleCommand(StrWrapper<Chord> wrapper, StrAnswerBuilder strAnswerBuilder) {
        super(wrapper, strAnswerBuilder);
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
