package ru.trankwilizator.quartofifthcircle.logic.scale.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;

class MinorNaturalNaturalScaleCalculatorTest {

    NaturalScaleCalculator minorNaturalScaleCalculator = new NaturalScaleCalculator();

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
        generalCase(new Tonality(Notes.A, Fret.MINOR), notes);
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
        generalCase(new Tonality(Notes.Gd, Fret.MINOR), notes);
    }

    private void generalCase(Tonality tonic, Notes[] expectedNotes){
        testDoesntThrow(tonic);
        testEquals(expectedNotes,tonic);
    }

    private void testDoesntThrow(Tonality note){
        Assertions.assertDoesNotThrow(()-> minorNaturalScaleCalculator.calculate(note));
    }

    private void testEquals(Notes[] notes, Tonality tonic){

        Notes[] actualNotes = minorNaturalScaleCalculator.calculate(tonic);
        int i=0;
        for (Notes n:
             actualNotes) {
            LoggerFactory.getLogger(System.Logger.class).info("expected = " + notes[i] + ", actual = " + n);
            Assertions.assertEquals(notes[i++], n);
        }
    }

}