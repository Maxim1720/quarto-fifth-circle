package ru.trankwilizator.quartofifthcircle.logic.scale;

import ru.trankwilizator.quartofifthcircle.command.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;

public class Scale {
    public Notes[] getNotes(Chord chord){
        return new ScaleCalculator().calculate(chord);
    }
}
