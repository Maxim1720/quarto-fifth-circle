package ru.trankwilizator.quartofifthcircle.logic.tonality.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.trankwilizator.quartofifthcircle.exception.TonalityException;

class TonalityValidatorTest {

    TonalityValidatorImpl chordValidator = new TonalityValidatorImpl();

    @Test
    void testAm(){
        Assertions.assertDoesNotThrow(()->chordValidator.validate("Am"));
    }

    @Test
    void testAA(){
        Assertions.assertThrows(TonalityException.class, ()-> chordValidator.validate("AA"));
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