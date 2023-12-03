package ru.trankwilizator.quartofifthcircle.message.processor.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.NotesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.NotesToTonalitiesReceiverAdapter;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverter;

@Component("getMelodicScaleCommand")
public class GetMelodicScaleCommand extends AbsCommand{
    @Autowired
    public GetMelodicScaleCommand(@Qualifier("melodicScale") NotesReceiver notesReceiver,
                                  TonalityConverter tonalityConverter){
        super(new NotesToTonalitiesReceiverAdapter(notesReceiver), tonalityConverter);
    }
}
