package ru.trankwilizator.quartofifthcircle.logic.chord;

import lombok.Getter;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Getter
public class Chord {
    private final Notes keyNote;
    private final Fret fret;

    public Chord(Notes keyNote, Fret fret){
        this.fret = fret;
        this.keyNote = keyNote;
    }


    @Override
    public String toString() {
        String chordTitle = keyNote.toString();
        if(fret == Fret.MINOR){
            chordTitle += fret.toString().toLowerCase().charAt(0);
        }
        return chordTitle;
    }
}
