package ru.trankwilizator.quartofifthcircle.logic;

import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.util.Notes;

public interface NotesReceiver {
    Notes[] notes(Tonality tonality);
}
