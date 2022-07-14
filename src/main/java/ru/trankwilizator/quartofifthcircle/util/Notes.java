package ru.trankwilizator.quartofifthcircle.util;

public enum Notes {
    A("A"),
    Ad("A#"),
    B("B"),
    C("C"),
    Cd("C#"),
    D("D"),
    Dd("D#"),
    E("E"),
    F("F"),
    Fd("F#"),
    G("G"),
    Gd("G#");

    final String title;

    Notes(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
