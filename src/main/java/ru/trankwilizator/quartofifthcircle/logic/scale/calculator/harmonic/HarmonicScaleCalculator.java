package ru.trankwilizator.quartofifthcircle.logic.scale.calculator.harmonic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Component
public class HarmonicScaleCalculator implements ScaleCalculator {

    private final NaturalScaleCalculator naturalScaleCalculator;

    @Autowired
    public HarmonicScaleCalculator(NaturalScaleCalculator naturalScaleCalculator) {
        this.naturalScaleCalculator = naturalScaleCalculator;
    }

    @Override
    public Notes[] calculate(Tonality tonality) {
        Notes[] notes = naturalScaleCalculator.calculate(tonality);

        if(tonality.getFret().equals(Fret.MINOR)){
            notes[6] = getFrom(notes[6],1);
        }
        else {
            notes[5] = getFrom(notes[5],-1);
        }
        return notes;
    }

    private Notes getFrom(Notes note, int i){
        return Notes.values()[NotePositionCorrector.correct(note.ordinal() + i)];
    }
}
