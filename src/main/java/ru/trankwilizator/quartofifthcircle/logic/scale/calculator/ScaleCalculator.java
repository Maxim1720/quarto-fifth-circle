package ru.trankwilizator.quartofifthcircle.logic.scale.calculator;


import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;

public interface ScaleCalculator {
    Notes[] calculate(Tonality tonality);
}
