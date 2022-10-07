package ru.trankwilizator.quartofifthcircle.logic.tonality;

import lombok.Getter;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Getter
public class Tonality {
    private final Notes keyNote;
    private final Fret fret;

    public Tonality(Notes keyNote, Fret fret){
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
