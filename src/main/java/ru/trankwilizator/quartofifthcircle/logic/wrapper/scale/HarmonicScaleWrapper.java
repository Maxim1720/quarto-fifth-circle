package ru.trankwilizator.quartofifthcircle.logic.wrapper.scale;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.scale.harmonic.HarmonicScale;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Component
public class HarmonicScaleWrapper extends StrWrapper<Notes> {
    private final HarmonicScale harmonicScale;

    protected HarmonicScaleWrapper(ChordConverter chordConverter, HarmonicScale harmonicScale) {
        super(chordConverter);
        this.harmonicScale = harmonicScale;
    }

    @Override
    protected Notes[] getObjects(Chord tonicChord) {
        return harmonicScale.getNotes(tonicChord);
    }
}
