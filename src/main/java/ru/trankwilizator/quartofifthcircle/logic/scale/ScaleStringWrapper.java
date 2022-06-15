package ru.trankwilizator.quartofifthcircle.logic.scale;

import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverterImpl;

public class ScaleStringWrapper {
    public String[] getNotesAsStrings(String chord) {
        Chord tonicChord = new ChordConverter().convertToChord(chord);
        Notes[] notes = new Scale().getNotes(tonicChord);
        String[] strs = new String[notes.length];
        for (int i = 0; i < notes.length; i++) {
            strs[i] = notes[i].toString();
        }
        return strs;
    }

}
