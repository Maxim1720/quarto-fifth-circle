package ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate.step.ScalePositioner;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate.util.ScaleCalculateStrategy;

@Component
public class ScaleCalculator implements IScaleCalculator {
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
