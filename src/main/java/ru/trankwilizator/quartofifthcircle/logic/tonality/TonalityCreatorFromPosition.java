package ru.trankwilizator.quartofifthcircle.logic.tonality;

import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.util.NotePositionCorrector;

public class TonalityCreatorFromPosition {

    public static Tonality create(int pos, Fret fret){
        return new Tonality(Notes.values()[
                NotePositionCorrector.correct(pos)], fret);
    }

}
