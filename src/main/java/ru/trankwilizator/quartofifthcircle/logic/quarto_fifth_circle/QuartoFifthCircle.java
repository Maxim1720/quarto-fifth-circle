package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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
        int[] indexes = new int[tonalities.length-1];
        if (tonic.getFret().equals(Fret.MINOR)) {
            chords[1] = new Chord(notes[2], Fret.MAJOR);
            chords[2] = new Chord(notes[3], Fret.MINOR);
            chords[3] = new Chord(notes[4], Fret.MINOR);
            chords[4] = new Chord(notes[5], Fret.MAJOR);
            chords[5] = new Chord(notes[6], Fret.MAJOR);
        } else {
            chords[1] = new Chord(notes[1], Fret.MINOR);
            chords[2] = new Chord(notes[2], Fret.MINOR);
            chords[3] = new Chord(notes[3], Fret.MAJOR);
            chords[4] = new Chord(notes[4], Fret.MAJOR);
            chords[5] = new Chord(notes[5], Fret.MINOR);
        }
        return chords;
    }
}
