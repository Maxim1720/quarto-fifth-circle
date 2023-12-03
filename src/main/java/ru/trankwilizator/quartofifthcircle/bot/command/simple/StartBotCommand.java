package ru.trankwilizator.quartofifthcircle.bot.command.simple;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.bot.command.BotCommand;
import ru.trankwilizator.quartofifthcircle.message.processor.MessageProcessor;
import ru.trankwilizator.quartofifthcircle.message.processor.simple.SimpleMessageProcessor;

@Component
public class StartBotCommand extends BotCommand {

    protected StartBotCommand() {
        super(new SimpleMessageProcessor(
                "Welcome to the Quarto Fifth Circle Rofl Bot.\n"+
                "Please, select command then i can help you :)"
        ));
    }

    @Override
    public String getCommandIdentifier() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "Начало работы с ботом";
    }
}
