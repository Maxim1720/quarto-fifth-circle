package ru.trankwilizator.quartofifthcircle.logic.chord;

import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.command.util.NotePositionCorrector;

public class ChordCreatorFromPosition {

    public static Chord createChord(int pos, Fret fret){
        return new Chord(Notes.values()[
                NotePositionCorrector.correct(pos)], fret);
    }

}
