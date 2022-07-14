package ru.trankwilizator.quartofifthcircle.logic.scale.calculate;


import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface IScaleCalculator {

    Notes[] calculate(Chord tonicChord);
}
