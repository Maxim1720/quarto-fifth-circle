package ru.trankwilizator.quartofifthcircle.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.trankwilizator.quartofifthcircle.bot.SpringTelegramBot;

@RestController
@AllArgsConstructor
public class WebHookController {

    private final SpringTelegramBot springTelegramBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return springTelegramBot.onWebhookUpdateReceived(update);
    }

}
