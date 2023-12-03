package ru.trankwilizator.quartofifthcircle.logic.str_converter;

import ru.trankwilizator.quartofifthcircle.logic.TonalitiesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverter;

public class StrTonalityWrapper implements StrWrapper {
    private final TonalitiesReceiver tonalitiesReceiver;
    private final TonalityConverter tonalityConverter;
    public StrTonalityWrapper(TonalitiesReceiver tonalitiesReceiver,
                              TonalityConverter tonalityConverter){
        this.tonalitiesReceiver = tonalitiesReceiver;
        this.tonalityConverter = tonalityConverter;
    }
    @Override
    public String[] getAsStrings(String keyTonality) {
        Tonality[] tonalities = tonalitiesReceiver.chords(tonalityConverter.convert(keyTonality));
        return stringsFromArray(tonalities);
    }
    private String[] stringsFromArray(Tonality[] tonalities){
        String[] strings= new String[tonalities.length];
        for (int i = 0; i < tonalities.length; i++) {
            strings[i] = tonalities[i].toString();
        }
        return strings;
    }
}

