package ru.trankwilizator.quartofifthcircle.logic;

import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;

public interface TonalitiesReceiver {
    Tonality[] chords(Tonality key);
}
