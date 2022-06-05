package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.logic.Fret;
import ru.trankwilizator.quartofifthcircle.logic.chord.ChordCreatorFromPosition;

public final class MinorCalculator extends Calculator {

    protected void calculateMinors() {
        positions[3] = keyPosition - 5;
        positions[4] = keyPosition + 5;

        chords[3] = ChordCreatorFromPosition.createChord(positions[3], Fret.MINOR);
        chords[4] = ChordCreatorFromPosition.createChord(positions[4], Fret.MINOR);
    }

    protected void calculateMajors() {
        positions[0] = keyPosition + 3;
        positions[1] = positions[0] + 5;
        positions[2] = positions[0] - 5;

        chords[0] = ChordCreatorFromPosition.createChord(positions[0], Fret.MAJOR);
        chords[1] = ChordCreatorFromPosition.createChord(positions[1], Fret.MAJOR);
        chords[2] = ChordCreatorFromPosition.createChord(positions[2], Fret.MAJOR);

    }
}
