package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.quartoFifthCircle.QuartoFifthCircleWrapper;

import java.util.Arrays;


class QuartoFifthCircleWrapperTest {


    QuartoFifthCircleWrapper quartoFifthCircleWrapper = Mockito.mock(QuartoFifthCircleWrapper.class);//new QuartoFifthCircleWrapper();
    Logger logger = Mockito.mock(Logger.class);


    @Test
    void doesntThrow(){
        Assertions.assertDoesNotThrow(()->quartoFifthCircleWrapper.getAsStrings("Am"));
    }

    @Test
    void testCaseAm(){
        String[] chords = new String[]{
                "C","F","G", "Em", "Dm"
        };
        testCase("Am", chords);
    }

    @Test
    void testCaseCm(){
        String[] chords = new String[]{
                "D#","G#","A#", "Gm", "Fm"
        };
        testCase("Cm", chords);
    }

    void testCase(String chord, String[] testChords){

        String[] chords = quartoFifthCircleWrapper.getAsStrings(chord);

        int i=0;
        for (String s:
             chords) {
            Assertions.assertEquals(testChords[i++], s);
        }

    }

    @Test
    void testCaseAdm(){

        String[] chords = new String[]{
                "C#",
                "F#",
                "G#",
                "Fm",
                "D#m"
        };
        testCase("A#m", chords);

    }

    @Test
    void print(){

        Assertions.assertDoesNotThrow(
                ()->{
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Am")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("A#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Bm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Cm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("C#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Dm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("D#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Em")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Fm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("F#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("Gm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("G#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("A")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("A#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("B")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("C")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("C#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("D")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("D#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("E")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("F")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("F#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("G")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getAsStrings("G#")));
                }
        );

    }

}