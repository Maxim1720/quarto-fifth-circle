package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.logic.scale.Scale;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.NaturalScale;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.step.ScalePositioner;

@Service
@Qualifier("quartoFifthCircle")
public class QuartoFifthCircle implements IQuartoFifthCircle {

    private final Scale scale;

    public QuartoFifthCircle(NaturalScale scale) {
        this.scale = scale;
    }

    @Override
    public Tonality[] chords(Tonality tonality) {
        Notes[] notes = scale.notes(tonality);
        return makeChords(notes, tonality);
    }

    private Tonality[] makeChords(Notes[] notes, Tonality tonic) {


        Tonality[] tonalities = new Tonality[ScalePositioner.NOTES_COUNT - 1];
        tonalities[0] = tonic;
        if (tonic.getFret().equals(Fret.MINOR)) {
            tonalities[1] = new Tonality(notes[2], Fret.MAJOR);
            tonalities[2] = new Tonality(notes[3], Fret.MINOR);
            tonalities[3] = new Tonality(notes[4], Fret.MINOR);
            tonalities[4] = new Tonality(notes[5], Fret.MAJOR);
            tonalities[5] = new Tonality(notes[6], Fret.MAJOR);
        } else {
            tonalities[1] = new Tonality(notes[1], Fret.MINOR);
            tonalities[2] = new Tonality(notes[2], Fret.MINOR);
            tonalities[3] = new Tonality(notes[3], Fret.MAJOR);
            tonalities[4] = new Tonality(notes[4], Fret.MAJOR);
            tonalities[5] = new Tonality(notes[5], Fret.MINOR);
        }
        return tonalities;
    }
}
