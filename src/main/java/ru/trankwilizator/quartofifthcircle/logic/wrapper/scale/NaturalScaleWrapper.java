package ru.trankwilizator.quartofifthcircle.logic.wrapper.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.NaturalScale;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;

@Component
@Qualifier("naturalScaleWrapper")
public class NaturalScaleWrapper extends StrWrapper<Notes> {

    private final Scale scale;
    @Autowired
    protected NaturalScaleWrapper(ChordConverter chordConverter, NaturalScale scale) {
        super(chordConverter);
        this.scale = scale;
    }

    @Override
    protected Notes[] getObjects(Chord tonicChord) {
        return scale.getNotes(tonicChord);
    }
}
