package ru.trankwilizator.quartofifthcircle.logic.scale.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.ScaleCalculator;

class MinorScaleCalculatorTest {

    ScaleCalculator minorScaleCalculator = new ScaleCalculator();

    @Test
    void testAm(){

        Notes[] notes = new Notes[]{
                Notes.A,
                Notes.B,
                Notes.C,
                Notes.D,
                Notes.E,
                Notes.F,
                Notes.G
        };
        generalCase(new Chord(Notes.A, Fret.MINOR), notes);
    }

    @Test
    void testGdm(){

        Notes[] notes = new Notes[]{
                Notes.Gd,
                Notes.Ad,
                Notes.B,
                Notes.Cd,
                Notes.Dd,
                Notes.E,
                Notes.Fd
        };
        generalCase(new Chord(Notes.Gd, Fret.MINOR), notes);
    }

    private void generalCase(Chord tonic, Notes[] expectedNotes){
        testDoesntThrow(tonic);
        testEquals(expectedNotes,tonic);
    }

    private void testDoesntThrow(Chord note){
        Assertions.assertDoesNotThrow(()->minorScaleCalculator.calculate(note));
    }

    private void testEquals(Notes[] notes, Chord tonic){

        Notes[] actualNotes = minorScaleCalculator.calculate(tonic);
        int i=0;
        for (Notes n:
             actualNotes) {
            LoggerFactory.getLogger(System.Logger.class).info("expected = " + notes[i] + ", actual = " + n);
            Assertions.assertEquals(notes[i++], n);
        }
    }

}