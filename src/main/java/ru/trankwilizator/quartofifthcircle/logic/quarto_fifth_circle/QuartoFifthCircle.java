package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import lombok.Getter;
import ru.trankwilizator.quartofifthcircle.logic.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator.ChordCalculator;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator.ChordCalculatorFabric;

public class QuartoFifthCircle {

    public Chord[] getChords(Chord chord) {
        int keyNotePosition = chord.getKeyNote().ordinal();
        ChordCalculator chordCalculator = ChordCalculatorFabric.INSTANCE(chord.getFret());
        return chordCalculator.calculateChords(keyNotePosition);
    }

}
