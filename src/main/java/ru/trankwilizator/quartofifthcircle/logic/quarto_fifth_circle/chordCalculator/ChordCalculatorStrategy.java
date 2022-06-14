package ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.chordCalculator;

import ru.trankwilizator.quartofifthcircle.command.util.Fret;

public final class ChordCalculatorStrategy {

    public static ChordCalculator INSTANCE(Fret chordFret){

        ChordCalculator chordCalculator = null;

        switch (chordFret){
            case MINOR -> chordCalculator = new MinorCalculator();
            case MAJOR -> chordCalculator = new MajorCalculator();
        }
        return chordCalculator;
    }

}
