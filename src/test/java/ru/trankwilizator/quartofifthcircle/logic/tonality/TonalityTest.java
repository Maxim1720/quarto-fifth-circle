package ru.trankwilizator.quartofifthcircle.logic.tonality;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

class TonalityTest {

    @Test
    void testToString() {
        Tonality tonality = new Tonality(Notes.A, Fret.MINOR);
        Assertions.assertEquals("Am", tonality.toString());
    }

    @Test
    void testAdmToString(){
        Tonality tonality = new Tonality(Notes.Ad, Fret.MINOR);
        Assertions.assertEquals("A#m", tonality.toString());
    }


    @Test
    void testAdToString(){
        Tonality tonality = new Tonality(Notes.Ad, Fret.MAJOR);
        Assertions.assertEquals("A#", tonality.toString());
    }

    @Test
    void testAToString(){
        Tonality tonality = new Tonality(Notes.A, Fret.MAJOR);
        Assertions.assertEquals("A", tonality.toString());
    }
}