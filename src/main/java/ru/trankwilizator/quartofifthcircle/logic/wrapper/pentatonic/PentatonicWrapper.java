package ru.trankwilizator.quartofifthcircle.logic.wrapper.pentatonic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.pentatonic.Pentatonic;

@Component
@Qualifier("pentatonicWrapper")
public class PentatonicWrapper extends StrWrapper<Notes> {

    private final Pentatonic pentatonic;

    @Autowired
    protected PentatonicWrapper(ChordConverter chordConverter, Pentatonic pentatonic) {
        super(chordConverter);
        this.pentatonic = pentatonic;
    }
    @Override
    protected Notes[] getObjects(Chord tonicChord) {
        return pentatonic.getNotes(tonicChord);
    }
}
