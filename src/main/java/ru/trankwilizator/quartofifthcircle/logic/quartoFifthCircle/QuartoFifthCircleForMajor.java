package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

public class QuartoFifthCircleForMajor extends QuartoFifthCircle {
    @Override
    protected void calculateMinors() {
        getChordsSteps()[2] = getKeyNotePosition() - 3;
        getChordsSteps()[3] = getChordsSteps()[2] - 5;
        getChordsSteps()[4] = getChordsSteps()[2] + 5;
    }

    @Override
    protected void calculateMajors() {
        getChordsSteps()[0] = getKeyNotePosition() + 5;
        getChordsSteps()[1] = getKeyNotePosition() - 5;
    }


}
