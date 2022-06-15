package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trankwilizator.quartofifthcircle.logic.ChordsGetter;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverterImpl;

import java.util.Arrays;

public class QuartoFifthCircleWrapper implements ChordsGetter<String> {

    private final QuartoFifthCircle quartoFifthCircle;

    public QuartoFifthCircleWrapper(){
        this.quartoFifthCircle = new QuartoFifthCircle();
    }

    @Override
    public String[] getChords(String keyChord) throws IllegalArgumentException {

        Chord chord = new ChordConverter().convertToChord(keyChord);
        Chord[] chords = quartoFifthCircle.getChords(chord);

        String[] res = receiveStrChords(chords);
        LoggerFactory.getLogger(System.Logger.class).info(Arrays.toString(res) + " " + keyChord);

        return res;
    }

    private String[] receiveStrChords(Chord[] chords){
        String[] strChords = new String[chords.length];
        int i=0;
        for (Chord c:
                chords) {
            strChords[i++] = c.toString();
        }
        return strChords;
    }

}
