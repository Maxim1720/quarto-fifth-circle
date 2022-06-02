package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import lombok.Getter;
import ru.trankwilizator.quartofifthcircle.logic.ChordsGetter;
import ru.trankwilizator.quartofifthcircle.logic.Notes;

public abstract class QuartoFifthCircle implements ChordsGetter<Notes> {

    private final int CHORDS_COUNT = 12;
    private final int CHORDS_POSITIONS_COUNT = 5;
    private final Notes[] notes = new Notes[CHORDS_POSITIONS_COUNT];

    private int noteIndex = 0;

    @Getter
    private int keyNotePosition;

    @Getter
    private int[] chordsSteps = new int[CHORDS_POSITIONS_COUNT];

    @Override
    public Notes[] getChords(Notes keyChord) {
        keyNotePosition = keyChord.ordinal();
        calculateMajors();
        calculateMinors();
        calculateAll();
        return notes;
    }

    protected abstract void calculateMajors();
    protected abstract void calculateMinors();

    protected void calculateAll(){
        for(int i = 0; i< chordsSteps.length; i++){
            setNote(chordsSteps[i]);
        }
    }
    private void setNote(int step){
        int position = step;//keyNotePosition+step;
        position = correctPosition(position);
        notes[noteIndex++] = Notes.values()[position];
    }

    private int correctPosition(int position){
        if(position >= CHORDS_COUNT){
            position-=CHORDS_COUNT;
        }
        else if(position < 0){
            position+=CHORDS_COUNT;
        }
        return position;
    }

}
