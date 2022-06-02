package ru.trankwilizator.quartofifthcircle.bot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
public class SpringTelegramBot extends SpringWebhookBot {

    private String botPath;
    private String botUsername;
    private String botToken;

    public SpringTelegramBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }
}
