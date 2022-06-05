package ru.trankwilizator.quartofifthcircle.logic.chord.validator;

import ru.trankwilizator.quartofifthcircle.logic.exception.ChordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChordValidator {

    private Matcher chordMatcher;

    private static final String MAJOR_REGEX = "^[A-Ga-g]#?m$";
    private static final String MINOR_REGEX = "^[A-Ga-g]#?$";

    public void validate(String chord) throws ChordException {
        try {
            check(chord, MINOR_REGEX);
        }
        catch (ChordException e){
            check(chord, MAJOR_REGEX);
        }
    }


    private void check(String chord, String regex){
        Pattern chordPattern = Pattern.compile(regex);
        chordMatcher = chordPattern.matcher(chord);
        String message = "Incorrect chord: ";
        if(isWrongChord(chord)){
            throw new ChordException(message + chord);
        }
    }

   /* public ChordValidator(){
        chordPattern = Pattern.compile(chordRegex());
    }*/


    private boolean isWrongChord(String chord){
        return !chordMatcher.find()
                || chord.toLowerCase().contains("e#")
                || chord.toLowerCase().contains("b#");

    }

}
