package ru.trankwilizator.quartofifthcircle.logic.scale.calculator;


import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public interface ScaleCalculator {

    Notes[] calculate(Chord tonicChord);
}
