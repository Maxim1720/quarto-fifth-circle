package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.logic.chord.ChordCreatorFromPosition;

public final class MajorCalculator extends Calculator{
    @Override
    protected void calculateMinors() {

        int parallelMinorPosition = keyPosition - INTERVAL_MINOR_THIRD;
        positions[2] = parallelMinorPosition;
        positions[3] = parallelMinorPosition - INTERVAL_QUARTO;
        positions[4] = parallelMinorPosition + INTERVAL_QUARTO;

        chords[2] = ChordCreatorFromPosition.createChord(positions[2],Fret.MINOR);
        chords[3] = ChordCreatorFromPosition.createChord(positions[3],Fret.MINOR);
        chords[4] = ChordCreatorFromPosition.createChord(positions[4],Fret.MINOR);
    }

    @Override
    protected void calculateMajors() {
        positions[0] = keyPosition + INTERVAL_QUARTO;
        positions[1] = keyPosition - INTERVAL_QUARTO;

        chords[0] = ChordCreatorFromPosition.createChord(positions[0],Fret.MAJOR);
        chords[1] = ChordCreatorFromPosition.createChord(positions[1],Fret.MAJOR);
    }


}
