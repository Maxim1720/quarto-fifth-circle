package ru.trankwilizator.quartofifthcircle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircle;

@Configuration
public class QuartoFifthCircleConfig {


    @Bean
    QuartoFifthCircle quartoFifthCircle(){
        return new QuartoFifthCircle();
    }

}
