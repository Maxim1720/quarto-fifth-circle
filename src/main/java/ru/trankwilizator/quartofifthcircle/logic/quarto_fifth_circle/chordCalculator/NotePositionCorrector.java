package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

public class NotePositionCorrector {
    private static final int ALL_CHORDS_COUNT = 12;

    public static int correct(int position){
        if(position >= ALL_CHORDS_COUNT){
            position-= ALL_CHORDS_COUNT;
        }
        else if(position < 0){
            position+= ALL_CHORDS_COUNT;
        }
        return position;
    }

}
