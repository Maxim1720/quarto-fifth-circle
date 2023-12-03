package ru.trankwilizator.quartofifthcircle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.trankwilizator.quartofifthcircle.bot.Bot;

@RestController
public class Controller {

    private final Bot bot;

    @Autowired
    public Controller(Bot bot) {
        this.bot = bot;
    }

    @GetMapping("/startBot")
    public void start(){
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
