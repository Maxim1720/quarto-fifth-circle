package ru.trankwilizator.quartofifthcircle.logic.chord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

class ChordTest {

    @Test
    void testToString() {
        Chord chord = new Chord(Notes.A, Fret.MINOR);
        Assertions.assertEquals("Am", chord.toString());
    }

    @Test
    void testAdmToString(){
        Chord chord = new Chord(Notes.Ad, Fret.MINOR);
        Assertions.assertEquals("A#m", chord.toString());
    }


    @Test
    void testAdToString(){
        Chord chord = new Chord(Notes.Ad, Fret.MAJOR);
        Assertions.assertEquals("A#", chord.toString());
    }

    @Test
    void testAToString(){
        Chord chord = new Chord(Notes.A, Fret.MAJOR);
        Assertions.assertEquals("A", chord.toString());
    }
}