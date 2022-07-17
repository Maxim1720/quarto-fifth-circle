package ru.trankwilizator.quartofifthcircle.logic.scale.melodic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.melodic.MelodicScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Component
@Qualifier("melodicScale")
public class MelodicScale implements Scale {

    private final MelodicScaleCalculator melodicScaleCalculator;
    private final NaturalScaleCalculator naturalScaleCalculator;

    public MelodicScale(MelodicScaleCalculator melodicScaleCalculator,
                        NaturalScaleCalculator naturalScaleCalculator) {
        this.melodicScaleCalculator = melodicScaleCalculator;
    }

    @Override
    public Notes[] getNotes(Chord chord) {
        return melodicScaleCalculator.calculate(chord);
    }

    private Notes[] toNotesArray(List<Notes> notes){

        Notes[] notes1 = new Notes[notes.size()];
        int i=0;
        for (Notes n:
             notes) {
            notes1[i++] = n;
        }

        return notes1;
    }
}
