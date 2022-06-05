package ru.trankwilizator.quartofifthcircle.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.trankwilizator.quartofifthcircle.bot.Bot;
import ru.trankwilizator.quartofifthcircle.bot.SpringTelegramBot;

@Configuration
@AllArgsConstructor
public class BotConfig {

    private final TelegramConfig telegramConfig;
    @Bean
    public SetWebhook setWebhookInstance(){
        return SetWebhook.builder().url(telegramConfig.getWebhookPath()).build();
    }

    @Bean
    public SpringTelegramBot springTelegramBot(SetWebhook setWebhook){
        SpringTelegramBot springTelegramBot = new SpringTelegramBot(setWebhook);

        springTelegramBot.setBotPath(telegramConfig.getWebhookPath());
        springTelegramBot.setBotToken(telegramConfig.getBotToken());
        springTelegramBot.setBotUsername(telegramConfig.getBotName());

        return springTelegramBot;
    }


}
