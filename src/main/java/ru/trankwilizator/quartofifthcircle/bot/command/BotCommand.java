package ru.trankwilizator.quartofifthcircle.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.trankwilizator.quartofifthcircle.message.processor.MessageProcessor;

public abstract class BotCommand implements IBotCommand {
    private final MessageProcessor messageProcessor;
    protected BotCommand(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }
    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        messageProcessor.processMessage(absSender,message,strings);
    }
}
