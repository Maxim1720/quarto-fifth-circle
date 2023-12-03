package ru.trankwilizator.quartofifthcircle.logic.pentatonic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.logic.NotesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Service
public class Pentatonic implements NotesReceiver {
    public static int NOTES_COUNT = 5;
    private final NotesReceiver scale;

    @Autowired
    public Pentatonic(@Qualifier("naturalScale") NotesReceiver naturalScale) {
        this.scale = naturalScale;
    }

    private Notes[] getNotes(Tonality tonality) {
        Notes[] notes = scale.notes(tonality);
        Notes[] pentatonicNotes = new Notes[NOTES_COUNT];

        int[] skips = skips(tonality.getFret());

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

    @Override
    public Notes[] notes(Tonality tonality) {
        return getNotes(tonality);
    }
}
