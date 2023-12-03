package ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.util;

import ru.trankwilizator.quartofifthcircle.exception.TonalityException;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.step.MajorScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.step.MinorScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.step.ScalePositioner;

public class ScaleCalculateStrategy {

    public static ScalePositioner getByFret(Fret chordFret){
        switch (chordFret){
            case MINOR:
                return new MinorScale();
            case MAJOR:
                return new MajorScale();
            default: throw new TonalityException("Fret Not Found");
        }
    }

}
