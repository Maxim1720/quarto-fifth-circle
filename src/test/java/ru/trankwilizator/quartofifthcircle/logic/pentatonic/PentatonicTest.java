package ru.trankwilizator.quartofifthcircle.logic.pentatonic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.logic.NotesReceiver;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.NaturalScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;

class PentatonicTest {
    ScaleCalculator scaleCalculator = new NaturalScaleCalculator();
    NotesReceiver scale = new NaturalScale(scaleCalculator);
    Pentatonic pentatonic = new Pentatonic(scale);


    @Test
    void whenAmIsOK(){

        Tonality tonality = new Tonality(Notes.A, Fret.MINOR);

        Notes[] notes = new Notes[]{
                Notes.A,
                Notes.C,
                Notes.D,
                Notes.E,
                Notes.G
        };

        equalsTest(notes, tonality);

    }



    void equalsTest(Notes[] actual, Tonality tonic){

        Notes[] expected = pentatonic.notes(tonic);

        int i=0;
        for (Notes n:
             actual) {
            System.out.println(n.toString()+" "+expected[i].toString());
            Assertions.assertEquals(expected[i++], n);
        }

    }
}