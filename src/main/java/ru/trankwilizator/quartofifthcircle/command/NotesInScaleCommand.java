package ru.trankwilizator.quartofifthcircle.command;

import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.message.scale.ScaleMessageHandler;

public class NotesInScaleCommand extends AbsCommand {

    @Override
    protected String getAnswerOnCommand() {
        return "Присылай тональность и я покажу тебе ноты в гамме";
    }

    @Override
    protected CommandMessageHandler getCommandMessageHandler() {
        return new ScaleMessageHandler();
    }

    @Override
    public String getCommandIdentifier() {
        return "notes_in_scale";
    }

    @Override
    public String getDescription() {
        return "Получить ноты в гамме";
    }
}
