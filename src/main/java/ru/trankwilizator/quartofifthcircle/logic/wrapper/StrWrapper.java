package ru.trankwilizator.quartofifthcircle.logic.wrapper;

import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.logic.chord.Chord;
import ru.trankwilizator.quartofifthcircle.logic.chord.converter.ChordConverter;

import java.util.Arrays;

public abstract class StrWrapper<T> implements IStrWrapper{
    private final ChordConverter chordConverter;

    protected StrWrapper(ChordConverter chordConverter) {
        this.chordConverter = chordConverter;
    }

    public String[] getAsStrings(String keyChord) {
        Chord tonicChord = chordConverter.convertToChord(keyChord);
        T[] objects = getObjects(tonicChord);
        String[] res = receiveStrs(objects);
        LoggerFactory.getLogger(System.Logger.class).info(Arrays.toString(res) + " " + keyChord);
        return res;
    }

    private String[] receiveStrs(T[] objects){
        String[] strs = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            strs[i] = objects[i].toString();
        }
        return strs;
    }

    protected abstract T[] getObjects(Chord tonicChord);

}
