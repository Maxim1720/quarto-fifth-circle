package ru.trankwilizator.quartofifthcircle.logic.chord.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.validator.ChordValidatorImpl;

public class ChordConverterImpl implements ChordConverter{
    private final ChordValidatorImpl chordValidator;

    public ChordConverterImpl(){
        chordValidator = new ChordValidatorImpl();
    }

    public Chord convertToChord(String chord){
        chord = chord.toLowerCase();

        chordValidator.validate(chord);

        int substringEnd = chord.length();
        Fret fret = Fret.MAJOR;
        if(isMinor(chord)){
            fret = Fret.MINOR;
            substringEnd =  chord.indexOf("m");
        }
        //chordValidator.validate(chord);
        String keyNote = chord.substring(0, substringEnd);
        Notes note = convertStrToNote(keyNote);
        return new Chord(note,fret);
    }

    private Notes convertStrToNote(String note){
        note = note.toUpperCase().replace('#','d');
        LoggerFactory.getLogger(Logger.class).info(note, note.getClass());
        return Enum.valueOf(Notes.class, note);
    }

    private boolean isMinor(String chord){
        return chord.toLowerCase().contains("m");
    }




}
