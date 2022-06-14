package ru.trankwilizator.quartofifthcircle.logic.scale;

import ru.trankwilizator.quartofifthcircle.command.util.NotePositionCorrector;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.ScaleCalculateStrategy;

public class ScaleCalculator {
    public Notes[] calculate(Chord tonicChord) {
        Notes[] notes = new Notes[Scale.NOTES_COUNT];
        int[] steps = ScaleCalculateStrategy.getByFret(tonicChord.getFret()).getPositions();
        notes[0] = tonicChord.getKeyNote();
        for (int i = 1; i < Scale.NOTES_COUNT; i++) {
            notes[i] = Notes.values()[NotePositionCorrector.correct(notes[i - 1].ordinal() + steps[i-1])];
        }
        return notes;
    }
}
