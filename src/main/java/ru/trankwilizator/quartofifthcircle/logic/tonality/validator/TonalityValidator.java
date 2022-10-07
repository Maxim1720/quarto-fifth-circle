package ru.trankwilizator.quartofifthcircle.logic.tonality.validator;

import ru.trankwilizator.quartofifthcircle.exception.TonalityException;

public interface TonalityValidator {
    void validate(String strTonality) throws TonalityException;
}
