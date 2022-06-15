package ru.trankwilizator.quartofifthcircle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessageHandlerConfig {
    private final Map<String, CommandMessageHandler> map;

    @Autowired
    public MessageHandlerConfig(Map<String, CommandMessageHandler> map){
        this.map = map;
    }


    @Bean
    HashMap<String, CommandMessageHandler> messageHandlers() {
        return (HashMap<String, CommandMessageHandler>) map;
    }


}
