package ru.trankwilizator.quartofifthcircle.logic.tonality.validator;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.exception.TonalityException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TonalityValidatorImpl implements TonalityValidator {

    private Matcher tonalityMatcher;
    private static final String MAJOR_REGEX = "^[A-Ga-g]#?$";
    private static final String MINOR_REGEX = "^[A-Ga-g]#?[Mm]$";

    public void validate(String strTonality) throws TonalityException {
        try {
            check(strTonality, MINOR_REGEX);
        }
        catch (TonalityException e){
            check(strTonality, MAJOR_REGEX);
        }
    }

    private void check(String tonality, String regex){
        Pattern chordPattern = Pattern.compile(regex);
        tonalityMatcher = chordPattern.matcher(tonality);
        String message = "Incorrect chord: ";
        if(isWrong(tonality)){
            throw new TonalityException(message + tonality);
        }
    }


    private boolean isWrong(String chord){
        return !tonalityMatcher.find()
                || chord.toLowerCase().contains("e#")
                || chord.toLowerCase().contains("b#");
    }

}
