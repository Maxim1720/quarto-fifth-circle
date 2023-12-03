package ru.trankwilizator.quartofifthcircle.message.processor.command;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.TonalitiesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverter;

@Component
public class GetQuartoFifthCircleCommand extends AbsCommand{
    public GetQuartoFifthCircleCommand(TonalitiesReceiver chordsReceiver, TonalityConverter tonalityConverter) {
        super(chordsReceiver, tonalityConverter);
    }
}
