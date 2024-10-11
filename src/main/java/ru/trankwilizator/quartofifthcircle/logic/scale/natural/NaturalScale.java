package ru.trankwilizator.quartofifthcircle.logic.scale.natural;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.ScaleCalculator;

@Service
@Qualifier("naturalScale")
public class NaturalScale implements Scale {
    private final ScaleCalculator scaleCalculator;

    @Autowired
    public NaturalScale(@Qualifier("naturalScaleCalculator") ScaleCalculator scaleCalculator) {
        this.scaleCalculator = scaleCalculator;
    }

    public Notes[] getNotes(Chord chord){
        return scaleCalculator.calculate(chord);
    }
}
