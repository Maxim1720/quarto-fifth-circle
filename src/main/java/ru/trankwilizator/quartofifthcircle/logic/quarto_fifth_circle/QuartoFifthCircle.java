package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator.ChordCalculator;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator.ChordCalculatorStrategy;

public class QuartoFifthCircle {

    public Chord[] getChords(Chord chord) {
        int keyNotePosition = chord.getKeyNote().ordinal();
        ChordCalculator chordCalculator = ChordCalculatorStrategy.INSTANCE(chord.getFret());
        return chordCalculator.calculateChords(keyNotePosition);
    }

}
