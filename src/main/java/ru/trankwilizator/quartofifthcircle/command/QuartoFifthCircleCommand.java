package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.message.handler.quartofifthcircle.QuartoFifthCircleMessageHandler;

@Component
public class QuartoFifthCircleCommand extends AbsCommand {

    private static final String COMMAND_NAME = "quarto_fifth_circle";
    private static final String COMMAND_DESCRIPTION = "Получите аккорды из кварта-квинтового круга";

    private final QuartoFifthCircleMessageHandler quartoFifthCircleMessageHandler;

    @Autowired
    public QuartoFifthCircleCommand(QuartoFifthCircleMessageHandler quartoFifthCircleMessageHandler) {
        this.quartoFifthCircleMessageHandler = quartoFifthCircleMessageHandler;
    }

    @Override
    public String getCommandIdentifier() {
        return COMMAND_NAME;
    }

    @Override
    public String getDescription() {
        return COMMAND_DESCRIPTION;
    }

    @Override
    protected String getAnswerOnCommand() {
        return "Quarto Fifth Circle mode established, please send chord";
    }

    @Override
    protected CommandMessageHandler getCommandMessageHandler() {
        return quartoFifthCircleMessageHandler;
    }
}
