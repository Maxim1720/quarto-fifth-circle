package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.IScale;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.calculate.step.ScalePositioner;

@Service
@Qualifier("quartoFifthCircle")
public class QuartoFifthCircle implements IQuartoFifthCircle {

    private final IScale scale;

    public QuartoFifthCircle(IScale scale) {
        this.scale = scale;
    }

    @Override
    public Chord[] getChords(Chord chord) {
        Notes[] notes = scale.getNotes(chord);
        return makeChords(notes, chord);
    }

    private Chord[] makeChords(Notes[] notes, Chord tonic) {

        Chord[] chords = new Chord[ScalePositioner.NOTES_COUNT - 1];
        chords[0] = tonic;
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
