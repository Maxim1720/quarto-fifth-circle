package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

class QuartoFifthCircleForMinor extends QuartoFifthCircle {
    protected void calculateMinors() {
        getChordsSteps()[3] = getKeyNotePosition() - 5;
        getChordsSteps()[4] = getKeyNotePosition() + 5;
    }

    protected void calculateMajors() {
        getChordsSteps()[0] = getKeyNotePosition() + 3;
        getChordsSteps()[1] = getChordsSteps()[0] + 5;
        getChordsSteps()[2] = getChordsSteps()[0] - 5;
    }
}
