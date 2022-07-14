package ru.trankwilizator.quartofifthcircle.logic.scale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculate.IScaleCalculator;

@Service
public class Scale implements IScale{
    private final IScaleCalculator scaleCalculator;

    @Autowired
    public Scale(IScaleCalculator scaleCalculator) {
        this.scaleCalculator = scaleCalculator;
    }

    public Notes[] getNotes(Chord chord){
        return scaleCalculator.calculate(chord);
    }
}
