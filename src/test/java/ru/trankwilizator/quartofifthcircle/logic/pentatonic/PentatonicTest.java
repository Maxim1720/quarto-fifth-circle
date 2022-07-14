package ru.trankwilizator.quartofifthcircle.logic.pentatonic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.IScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate.IScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate.ScaleCalculator;

class PentatonicTest {
    IScaleCalculator scaleCalculator = new ScaleCalculator();
    IScale scale = new Scale(scaleCalculator);
    Pentatonic pentatonic = new Pentatonic(scale);


    @Test
    void whenAmIsOK(){

        Chord chord = new Chord(Notes.A, Fret.MINOR);

        Notes[] notes = new Notes[]{
                Notes.A,
                Notes.C,
                Notes.D,
                Notes.E,
                Notes.G
        };

        equalsTest(notes,chord);

    }



    void equalsTest(Notes[] actual, Chord tonic){

        Notes[] expected = pentatonic.getNotes(tonic);

        int i=0;
        for (Notes n:
             actual) {
            System.out.println(n.toString()+" "+expected[i].toString());
            Assertions.assertEquals(expected[i++], n);
        }

    }
}