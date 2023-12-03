package ru.trankwilizator.quartofifthcircle.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    }

    @Bean
    public java.util.logging.Logger fileLogger(@Value("${log.path}") String path) {
        java.util.logging.Logger logger =
                java.util
                        .logging
                        .Logger
                        .getLogger(
                                System.Logger.Level.INFO.getName()
                        );
        try {
            File file = new File(path);
            file.createNewFile();
            FileHandler fileHandler = new FileHandler(path, true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
