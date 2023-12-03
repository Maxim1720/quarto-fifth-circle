package ru.trankwilizator.quartofifthcircle.message.processor.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.NotesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.NotesToTonalitiesReceiverAdapter;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverter;

@Component
public class GetHarmonicScaleCommand extends AbsCommand{
    public GetHarmonicScaleCommand(@Qualifier("harmonicScale") NotesReceiver notesReceiver, TonalityConverter tonalityConverter) {
        super(new NotesToTonalitiesReceiverAdapter(notesReceiver),
                tonalityConverter);
    }
}
