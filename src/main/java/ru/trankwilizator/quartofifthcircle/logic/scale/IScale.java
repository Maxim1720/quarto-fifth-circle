package ru.trankwilizator.quartofifthcircle.logic.scale;

import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface IScale {
    Notes[] getNotes(Chord chord);
}
