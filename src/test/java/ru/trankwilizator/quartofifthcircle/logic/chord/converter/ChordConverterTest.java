package ru.trankwilizator.quartofifthcircle.logic.chord.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;


class ChordConverterTest {

    ChordConverter chordConverter = Mockito.mock(ChordConverter.class);//new ChordConverterImpl(chordValidator);

    @Test
    void convertAmToChordDoesntThrow(){
        doesntThrowConverting("Am");
        doesntThrowConverting("A#m");
        doesntThrowConverting("Bm");
        doesntThrowConverting("Cm");
        doesntThrowConverting("C#m");
        doesntThrowConverting("Dm");
        doesntThrowConverting("D#m");
        doesntThrowConverting("Em");
        doesntThrowConverting("Fm");doesntThrowConverting("F#m");
        doesntThrowConverting("Gm");doesntThrowConverting("G#m");

        doesntThrowConverting("A");
        doesntThrowConverting("A#");
        doesntThrowConverting("B");
        doesntThrowConverting("C");
        doesntThrowConverting("C#");
        doesntThrowConverting("D");
        doesntThrowConverting("D#");
        doesntThrowConverting("E");
        doesntThrowConverting("F");doesntThrowConverting("F#");
        doesntThrowConverting("G");doesntThrowConverting("G#");

        doesntThrowConverting("AM");
        doesntThrowConverting("aM");
        doesntThrowConverting("am");

    }

    @Test
    void convertAAthrowChordException(){
        throwChordException("AA");
        throwChordException("E#");
        throwChordException("B#");
    }


    void throwChordException(String brokenChord){
        Assertions.assertThrows(ChordException.class, ()->chordConverter.convertToChord(brokenChord));
    }

    void doesntThrowConverting(String chord){
        Assertions.assertDoesNotThrow(()->chordConverter.convertToChord(chord));
    }
}