package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.logic.Fret;
import ru.trankwilizator.quartofifthcircle.logic.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.ChordCreatorFromPosition;

public final class MajorCalculator extends Calculator{
    @Override
    protected void calculateMinors() {
        positions[2] = keyPosition- 3;
        positions[3] = positions[2] - 5;
        positions[4] = positions[2] + 5;

        chords[2] = ChordCreatorFromPosition.createChord(positions[2],Fret.MINOR);
        chords[3] = ChordCreatorFromPosition.createChord(positions[3],Fret.MINOR);
        chords[4] = ChordCreatorFromPosition.createChord(positions[4],Fret.MINOR);
    }

    @Override
    protected void calculateMajors() {
        positions[0] = keyPosition + 5;
        positions[1] = keyPosition - 5;

        chords[0] = ChordCreatorFromPosition.createChord(positions[0],Fret.MAJOR);
        chords[1] = ChordCreatorFromPosition.createChord(positions[1],Fret.MAJOR);
    }


}
