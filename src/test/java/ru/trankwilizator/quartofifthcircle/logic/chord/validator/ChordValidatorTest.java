package ru.trankwilizator.quartofifthcircle.logic.chord.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.logic.exception.ChordException;

import static org.junit.jupiter.api.Assertions.*;

class ChordValidatorTest {

    ChordValidator chordValidator = new ChordValidator();


    @Test
    void testAm(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("Am"));
    }

    @Test
    void testAA(){
        Assertions.assertThrows(ChordException.class, ()-> chordValidator.validate("AA"));
    }

}