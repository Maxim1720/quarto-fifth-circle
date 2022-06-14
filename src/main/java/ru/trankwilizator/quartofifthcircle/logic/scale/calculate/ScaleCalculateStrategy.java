package ru.trankwilizator.quartofifthcircle.logic.scale.calculate;

import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.command.util.Fret;

public class ScaleCalculateStrategy {

    public static Scale getByFret(Fret chordFret){
        switch (chordFret){
            case MINOR -> {
                return new MinorScale();
            }
            case MAJOR -> {
                return new MajorScale();
            }
            default -> throw new ChordException("Fret Not Found");
        }
    }

}
