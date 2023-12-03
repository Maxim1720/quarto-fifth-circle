package ru.trankwilizator.quartofifthcircle.logic.tonality.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.exception.TonalityException;
import ru.trankwilizator.quartofifthcircle.logic.tonality.validator.TonalityValidatorImpl;


class TonalityConverterTest {

    TonalityConverter tonalityConverter = new TonalityConverterImpl(new TonalityValidatorImpl());//Mockito.mock(ChordConverter.class);//new ChordConverterImpl(chordValidator);

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
        Assertions.assertThrows(TonalityException.class, ()-> tonalityConverter.convert(brokenChord));
    }

    void doesntThrowConverting(String chord){
        Assertions.assertDoesNotThrow(()-> tonalityConverter.convert(chord));
    }
}