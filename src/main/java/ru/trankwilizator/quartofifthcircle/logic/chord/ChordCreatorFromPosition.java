package ru.trankwilizator.quartofifthcircle.logic.chord;

import ru.trankwilizator.quartofifthcircle.logic.Fret;
import ru.trankwilizator.quartofifthcircle.logic.Notes;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator.NotePositionCorrector;

public class ChordCreatorFromPosition {

    public static Chord createChord(int pos, Fret fret){
        return new Chord(Notes.values()[
                NotePositionCorrector.correct(pos)], fret);
    }

}
