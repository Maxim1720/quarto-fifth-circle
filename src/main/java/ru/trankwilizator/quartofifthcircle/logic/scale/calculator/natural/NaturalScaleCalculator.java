package ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.step.ScalePositioner;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.util.ScaleCalculateStrategy;

@Component
public class NaturalScaleCalculator implements ScaleCalculator {
    public Notes[] calculate(Chord tonicChord) {
        Notes[] notes = new Notes[ScalePositioner.NOTES_COUNT];
        int[] steps = ScaleCalculateStrategy.getByFret(tonicChord.getFret()).getPositions();
        notes[0] = tonicChord.getKeyNote();
        for (int i = 1; i < ScalePositioner.NOTES_COUNT; i++) {
            notes[i] = Notes.values()[NotePositionCorrector.correct(notes[i - 1].ordinal() + steps[i-1])];
        }
        return notes;
    }
}
