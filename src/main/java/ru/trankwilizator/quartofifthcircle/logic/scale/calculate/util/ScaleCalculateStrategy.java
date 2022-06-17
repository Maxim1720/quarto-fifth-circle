package ru.trankwilizator.quartofifthcircle.logic.scale.calculate.util;

import ru.trankwilizator.quartofifthcircle.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.command.util.Fret;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.step.MajorScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.step.MinorScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.step.ScalePositioner;

public class ScaleCalculateStrategy {

    public static ScalePositioner getByFret(Fret chordFret){
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
