package ru.trankwilizator.quartofifthcircle.logic.wrapper.scale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.scale.melodic.MelodicScale;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.util.Notes;
@Component
@Qualifier("melodicScaleWrapper")
public class MelodicScaleWrapper extends StrWrapper<Notes> {
    private final MelodicScale melodicScale;

    protected MelodicScaleWrapper(ChordConverter chordConverter, MelodicScale melodicScale) {
        super(chordConverter);
        this.melodicScale = melodicScale;
    }

    @Override
    protected Notes[] getObjects(Chord tonicChord) {
        return melodicScale.getNotes(tonicChord);
    }
}
