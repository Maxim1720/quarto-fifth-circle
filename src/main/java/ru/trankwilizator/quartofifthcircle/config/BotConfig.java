package ru.trankwilizator.quartofifthcircle.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import ru.trankwilizator.quartofifthcircle.command.NotesInScaleCommand;
import ru.trankwilizator.quartofifthcircle.command.QuartoFifthCircleCommand;
import ru.trankwilizator.quartofifthcircle.command.StartCommand;

@Configuration
@AllArgsConstructor
public class BotConfig {
    @Bean
    public IBotCommand[] commands(){
        return new IBotCommand[]{
                new StartCommand(),
                new NotesInScaleCommand(),
                new QuartoFifthCircleCommand()
        };
    }


}
