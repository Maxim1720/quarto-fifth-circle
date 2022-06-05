package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public abstract class Calculator implements ChordCalculator {

    protected final Chord[] chords;
    protected final int[] positions;
    protected int keyPosition;

    public Calculator(){
        positions = new int[5];
        chords = new Chord[5];
    }

    @Override
    public int[] calculatePositions(int keyPosition) {
        this.keyPosition = keyPosition;
        calculateMajors();
        calculateMinors();
        return positions;
    }


    public Chord[] calculateChords(int keyPosition){
        calculateMajors();
        calculateMinors();
        return chords;
    }

    protected abstract void calculateMinors();
    protected abstract void calculateMajors();
}
