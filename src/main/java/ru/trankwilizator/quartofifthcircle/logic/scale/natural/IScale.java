package ru.trankwilizator.quartofifthcircle.logic.scale.natural;

import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface IScale {
    Notes[] getNotes(Chord chord);
}
