package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.message.handler.scale.ScaleMessageHandler;

@Component
public class NotesInScaleCommand extends AbsCommand {

    private final ScaleMessageHandler scaleMessageHandler;

    public NotesInScaleCommand(ScaleMessageHandler scaleMessageHandler) {
        this.scaleMessageHandler = scaleMessageHandler;
    }

    @Override
    protected String getAnswerOnCommand() {
        return "Присылай тональность и я покажу тебе ноты в гамме";
    }

    @Override
    protected CommandMessageHandler getCommandMessageHandler() {
        return scaleMessageHandler;
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
