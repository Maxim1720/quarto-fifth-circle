package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public abstract class Calculator implements ChordCalculator {

    protected final Chord[] chords;
    protected final int[] positions;
    protected int keyPosition;

    public Calculator(){
        positions = new int[QUARTO_FIFTH_CHORDS_COUNT_WITHOUT_TONIC];
        chords = new Chord[QUARTO_FIFTH_CHORDS_COUNT_WITHOUT_TONIC];
    }

    @Override
    public Chord[] calculateChords(int keyPosition){
        this.keyPosition = keyPosition;
        calculateMajors();
        calculateMinors();
        return chords;
    }

    protected abstract void calculateMinors();
    protected abstract void calculateMajors();
}
