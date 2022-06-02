package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.glassfish.grizzly.http.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.Notes;
import ru.trankwilizator.quartofifthcircle.logic.ChordsGetter;

@Component
public class QuartoFifthCircleWrapper implements ChordsGetter<String> {

    private QuartoFifthCircle quartoFifthCircle;

    @Override
    public String[] getChords(String keyChord) throws IllegalArgumentException {

        initQuartoFifthCircleByKeyChord(keyChord);

        String keyNote = keyNoteFromChord(keyChord);

        //Notes note = Enum.valueOf(Notes.class, keyNote);
        Notes note = convertStrToNote(keyNote);

        Notes[] notes = quartoFifthCircle.getChords(note);
        String[] res = receiveStrChords(notes);


        int minorsCount = 2;
        if (!isMinor(keyChord)) {
            minorsCount++;
        }
        for (int i = minorsCount, k = res.length-1; i>0; i--, k--) {
            res[k] += 'm';
        }
        return res;
    }


    private Notes convertStrToNote(String note){
        note = note.replace('#','d');
        return Enum.valueOf(Notes.class, note);
    }

    private String keyNoteFromChord(String keyChord){

        String keyNote;

        int substrignEnd = keyChord.length();
        if(isMinor(keyChord)){
            substrignEnd = keyChord.indexOf("m");
        }

        keyNote = keyChord.substring(0, substrignEnd);
        LoggerFactory.getILoggerFactory().getLogger(System.Logger.Level.ALL.getName()).info(
                "Key note = " + keyNote
        );

        return keyNote;
    }
    private void initQuartoFifthCircleByKeyChord(String keyChord){
        if (isMinor(keyChord)) {
            quartoFifthCircle = new QuartoFifthCircleForMinor();
        } else {
            quartoFifthCircle = new QuartoFifthCircleForMajor();
        }
    }


    private String[] receiveStrChords(Notes[] notes){

        String[] strChords = new String[notes.length];
        int i=0;
        for (Notes c:
                notes) {
            strChords[i++] = c.toString();
        }
        return strChords;
    }

    private boolean isMinor(String keyChord){
        return keyChord.contains("m");
    }


}
