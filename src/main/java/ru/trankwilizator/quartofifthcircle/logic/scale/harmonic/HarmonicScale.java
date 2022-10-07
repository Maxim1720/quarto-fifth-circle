package ru.trankwilizator.quartofifthcircle.logic.scale.harmonic;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.harmonic.HarmonicScaleCalculator;
import ru.trankwilizator.quartofifthcircle.util.Notes;

@Component
public class HarmonicScale implements Scale {

    private final HarmonicScaleCalculator scaleCalculator;

    public HarmonicScale(HarmonicScaleCalculator scaleCalculator) {
        this.scaleCalculator = scaleCalculator;
    }

    @Override
    public Notes[] notes(Tonality tonality) {
        return scaleCalculator.calculate(tonality);
    }
}
