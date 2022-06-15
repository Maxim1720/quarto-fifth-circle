package ru.trankwilizator.quartofifthcircle.logic.scale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ScaleStringWrapperTest {

    ScaleStringWrapper scaleStringWrapper = new ScaleStringWrapper();

    @Test
    void testAm(){
        generalTests("Am", new String[]{
                "A","B","C","D","E","F","G"
        });
    }


    private void generalTests(String chordStr, String[] expected){
        String[] actuals = scaleStringWrapper.getNotesAsStrings(chordStr);

        int i=0;
        for (String s:
             expected) {
            LoggerFactory.getLogger(System.Logger.class).info("expected = " + s + ", actual = " + actuals[i]);
            Assertions.assertEquals(s, actuals[i++]);
        }


    }


}