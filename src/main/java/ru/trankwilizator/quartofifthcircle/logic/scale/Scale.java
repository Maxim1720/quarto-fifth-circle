package ru.trankwilizator.quartofifthcircle.logic.scale;

import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface Scale {
    Notes[] getNotes(Chord chord);
}
