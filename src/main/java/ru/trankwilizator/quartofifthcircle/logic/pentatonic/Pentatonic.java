package ru.trankwilizator.quartofifthcircle.logic.pentatonic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.IScale;

@Service
public class Pentatonic {

    public static int NOTES_COUNT = 5;
    private final IScale scale;

    @Autowired
    public Pentatonic(IScale scale) {
        this.scale = scale;
    }

    public Notes[] getNotes(Chord tonicChord) {
        Notes[] notes = scale.getNotes(tonicChord);
        Notes[] pentatonicNotes = new Notes[NOTES_COUNT];

        int[] skips = skips(tonicChord.getFret());

        for (int i = 0, k = 0; i < notes.length; i++) {
            boolean can = false;
            for (int skip : skips) {
                if (i != skip) {
                    can = true;
                } else {
                    can = false;
                    break;
                }
            }
            if (can) {
                pentatonicNotes[k++] = notes[i];
            }
        }
        return pentatonicNotes;
    }

    private int[] skips(Fret fret) {
        int[] skips;
        if (fret.equals(Fret.MINOR)) {
            skips = new int[]{1, 5};
        } else {
            skips = new int[]{3, 6};
        }
        return skips;
    }

}
