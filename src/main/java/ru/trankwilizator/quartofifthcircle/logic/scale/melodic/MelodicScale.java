package ru.trankwilizator.quartofifthcircle.logic.scale.melodic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.melodic.MelodicScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Qualifier("melodicScale")
public class MelodicScale implements Scale {

    private final MelodicScaleCalculator melodicScaleCalculator;
    private final NaturalScaleCalculator naturalScaleCalculator;

    public MelodicScale(MelodicScaleCalculator melodicScaleCalculator,
                        NaturalScaleCalculator naturalScaleCalculator) {
        this.melodicScaleCalculator = melodicScaleCalculator;
        this.naturalScaleCalculator = naturalScaleCalculator;
    }

    @Override
    public Notes[] getNotes(Chord chord) {

        ScaleCalculator scaleCalculator1;
        ScaleCalculator scaleCalculator2;

        if(chord.getFret().equals(Fret.MINOR)){
            scaleCalculator1 = melodicScaleCalculator;
            scaleCalculator2 = naturalScaleCalculator;
        }
        else {
            scaleCalculator1 = naturalScaleCalculator;
            scaleCalculator2 = melodicScaleCalculator;
        }

        ArrayList<Notes> notes = new ArrayList<>(Arrays.stream(scaleCalculator1.calculate(chord)).toList());

        List<Notes> notesList = new ArrayList<>(Arrays.stream(scaleCalculator2.calculate(chord)).toList());

        Collections.reverse(notesList);

        notes.addAll(notesList);

        return toNotesArray(notes);
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
