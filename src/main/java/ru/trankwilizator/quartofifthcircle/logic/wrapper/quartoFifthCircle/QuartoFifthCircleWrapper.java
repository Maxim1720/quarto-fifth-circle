package ru.trankwilizator.quartofifthcircle.logic.wrapper.quartoFifthCircle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.IQuartoFifthCircle;

@Component
public class QuartoFifthCircleWrapper extends StrWrapper<Chord> {

    private final IQuartoFifthCircle quartoFifthCircle2;

    @Autowired
    protected QuartoFifthCircleWrapper(ChordConverter chordConverter,
                                       @Qualifier("quartoFifthCircle") IQuartoFifthCircle quartoFifthCircle2) {
        super(chordConverter);
        this.quartoFifthCircle2 = quartoFifthCircle2;
    }

    @Override
    protected Chord[] getObjects(Chord tonicChord) {
        return quartoFifthCircle2.getChords(tonicChord);
    }

}
