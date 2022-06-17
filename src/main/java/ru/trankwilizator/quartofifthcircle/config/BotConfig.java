package ru.trankwilizator.quartofifthcircle.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import ru.trankwilizator.quartofifthcircle.command.AbsCommand;
import ru.trankwilizator.quartofifthcircle.command.NotesInScaleCommand;
import ru.trankwilizator.quartofifthcircle.command.QuartoFifthCircleCommand;
import ru.trankwilizator.quartofifthcircle.command.StartCommand;

@Configuration
public class BotConfig {

    private final AbsCommand[] absCommands;

    @Autowired
    public BotConfig(AbsCommand[] absCommands) {
        this.absCommands = absCommands;
    }

    @Bean
    public IBotCommand[] commands(){
        return absCommands;
    }


}
