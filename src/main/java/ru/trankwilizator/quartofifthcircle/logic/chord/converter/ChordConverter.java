package ru.trankwilizator.quartofifthcircle.logic.chord.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.logic.Fret;
import ru.trankwilizator.quartofifthcircle.logic.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.validator.ChordValidator;

public class ChordConverter {
    ChordValidator chordValidator;

    public ChordConverter(){
        chordValidator = new ChordValidator();
    }

    public String convertToStr(Chord chord){
        return chord.toString();
    }

    public Chord convertToChord(String chord){

        new ChordValidator().validate(chord);

        int substringEnd = chord.length();
        Fret fret = Fret.MAJOR;
        if(isMinor(chord)){
            fret = Fret.MINOR;
            substringEnd =  chord.indexOf("m");
        }
        chordValidator.validate(chord);
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
        return chord.contains("m");
    }




}
