package ru.trankwilizator.quartofifthcircle.logic.scale.harmonic;

import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
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
    public Notes[] getNotes(Chord chord) {
        return scaleCalculator.calculate(chord);
    }
}
