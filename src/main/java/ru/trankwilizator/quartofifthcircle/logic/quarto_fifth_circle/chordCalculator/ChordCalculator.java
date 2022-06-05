package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface ChordCalculator {
    int[] calculatePositions(int keyPosition);
    Chord[] calculateChords(int keyPosition);
}
