package ru.trankwilizator.quartofifthcircle.message.processor.command;

import org.springframework.context.support.MessageSourceResourceBundle;

public class NoCommand implements Command{
    @Override
    public String execute(String key) {
        return MessageSourceResourceBundle.getBundle("messages").getString("bot.message.error");
    }
}
