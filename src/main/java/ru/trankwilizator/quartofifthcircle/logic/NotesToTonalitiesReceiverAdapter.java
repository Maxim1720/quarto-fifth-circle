package ru.trankwilizator.quartofifthcircle.logic;

import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;

public class NotesToTonalitiesReceiverAdapter implements TonalitiesReceiver {
    private final NotesReceiver notesReceiver;

    public NotesToTonalitiesReceiverAdapter(NotesReceiver notesReceiver){
        this.notesReceiver = notesReceiver;
    }

    @Override
    public Tonality[] chords(Tonality key) {
        Notes[] notes = notesReceiver.notes(key);
        Tonality[] tonalities = new Tonality[notes.length];
        for (int i = 0; i< tonalities.length; i++){
            tonalities[i] = new Tonality(notes[i], Fret.MAJOR);
        }
        return tonalities;
    }
}
