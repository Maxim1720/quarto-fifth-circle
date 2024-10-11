package ru.trankwilizator.quartofifthcircle.logic.scale.calculator.melodic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Component
public class MelodicScaleCalculator implements ScaleCalculator {

    private final NaturalScaleCalculator naturalScaleCalculator;

    @Autowired
    public MelodicScaleCalculator(NaturalScaleCalculator naturalScaleCalculator) {
        this.naturalScaleCalculator = naturalScaleCalculator;
    }

    @Override
    public Notes[] calculate(Chord tonicChord) {
        Notes[] notes = naturalScaleCalculator.calculate(tonicChord);
        if (tonicChord.getFret().equals(Fret.MINOR)){
            notes[5] = stepUp(notes[5]);
            notes[6] = stepUp(notes[6]);
        }
        else {
            notes[5] = stepDown(notes[5]);
            notes[6] = stepDown(notes[6]);
        }
        return notes;
    }

    private Notes stepUp(Notes note){
        return Notes.values()[NotePositionCorrector.correct(note.ordinal() + 1)];
    }
    private Notes stepDown(Notes note){
        return Notes.values()[NotePositionCorrector.correct(note.ordinal()-1)];
    }
}
