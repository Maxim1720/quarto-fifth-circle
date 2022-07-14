package ru.trankwilizator.quartofifthcircle.logic.chord;

import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;

public class ChordCreatorFromPosition {

    public static Chord createChord(int pos, Fret fret){
        return new Chord(Notes.values()[
                NotePositionCorrector.correct(pos)], fret);
    }

}
