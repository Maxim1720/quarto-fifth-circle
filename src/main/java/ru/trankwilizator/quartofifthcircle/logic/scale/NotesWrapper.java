package ru.trankwilizator.quartofifthcircle.logic.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;

@Component
public class NotesWrapper extends StrWrapper<Notes> {

    private final IScale scale;
    @Autowired
    protected NotesWrapper(ChordConverter chordConverter, IScale scale) {
        super(chordConverter);
        this.scale = scale;
    }

    @Override
    protected Notes[] getObjects(Chord tonicChord) {
        return scale.getNotes(tonicChord);
    }
}
