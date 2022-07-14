package ru.trankwilizator.quartofifthcircle.logic.scale.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.scale.IScale;

@Component
@Qualifier("notesWrapper")
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
