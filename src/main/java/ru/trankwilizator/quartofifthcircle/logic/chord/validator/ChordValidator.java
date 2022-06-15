package ru.trankwilizator.quartofifthcircle.logic.chord.validator;

import ru.trankwilizator.quartofifthcircle.exception.ChordException;

public interface ChordValidator {
    void validate(String chord) throws ChordException;
}
