package ru.trankwilizator.quartofifthcircle.logic.chord.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.exception.ChordException;

class ChordValidatorTest {

    ChordValidatorImpl chordValidator = new ChordValidatorImpl();

    @Test
    void testAm(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("Am"));
    }

    @Test
    void testAA(){
        Assertions.assertThrows(ChordException.class, ()-> chordValidator.validate("AA"));
    }

    @Test
    void testAM(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("AM"));
    }

    @Test
    void test_am(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("am"));
    }

    @Test
    void testA(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("A"));
    }

    @Test
    void test_a(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("a"));
    }

}