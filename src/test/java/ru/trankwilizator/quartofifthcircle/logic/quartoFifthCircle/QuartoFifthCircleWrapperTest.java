package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircleWrapper;

import java.util.Arrays;


@SpringBootTest
class QuartoFifthCircleWrapperTest {

    @Autowired
    QuartoFifthCircleWrapper quartoFifthCircleWrapper;

    @Autowired
    Logger logger;


    @Test
    void doesntThrow(){
        Assertions.assertDoesNotThrow(()->quartoFifthCircleWrapper.getChords("Am"));
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

        String[] chords = quartoFifthCircleWrapper.getChords(chord);

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
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Am")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("A#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Bm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Cm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("C#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Dm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("D#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Em")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Fm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("F#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("Gm")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("G#m")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("A")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("A#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("B")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("C")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("C#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("D")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("D#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("E")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("F")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("F#")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("G")));
                    logger.info(Arrays.toString(quartoFifthCircleWrapper.getChords("G#")));
                }
        );

    }

}