package ru.trankwilizator.quartofifthcircle.logic.tonality.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.tonality.validator.TonalityValidator;

@Component
public class TonalityConverterImpl implements TonalityConverter {
    private final TonalityValidator tonalityValidator;

    @Autowired
    public TonalityConverterImpl(TonalityValidator tonalityValidator) {
        this.tonalityValidator = tonalityValidator;
    }

    public Tonality convert(String tonality){
        tonality = tonality.toLowerCase();

        tonalityValidator.validate(tonality);

        int substringEnd = tonality.length();
        Fret fret = Fret.MAJOR;
        if(isMinor(tonality)){
            fret = Fret.MINOR;
            substringEnd =  tonality.indexOf("m");
        }

        String keyNote = tonality.substring(0, substringEnd);
        Notes note = convertStrToNote(keyNote);
        return new Tonality(note,fret);
    }

    private Notes convertStrToNote(String note){
        note = note.toUpperCase().replace('#','d');
        return Enum.valueOf(Notes.class, note);
    }

    private boolean isMinor(String tonality){
        return tonality.toLowerCase().contains("m");
    }




}
