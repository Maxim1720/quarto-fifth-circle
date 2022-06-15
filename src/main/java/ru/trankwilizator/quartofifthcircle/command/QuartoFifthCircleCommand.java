package ru.trankwilizator.quartofifthcircle.command;

import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.message.quartofifthcircle.QuartoFifthCircleMessageHandler;


public class QuartoFifthCircleCommand extends AbsCommand {

    private static final String COMMAND_NAME = "quarto_fifth_circle";
    private static final String COMMAND_DESCRIPTION = "Получите аккорды из кварта-квинтового круга";


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
        return new QuartoFifthCircleMessageHandler();
    }
}
