package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverterImpl;
import ru.trankwilizator.quartofifthcircle.logic.tonality.validator.TonalityValidatorImpl;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.QuartoFifthCircle;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.NaturalScale;
import ru.trankwilizator.quartofifthcircle.logic.str_converter.StrTonalityWrapper;

import java.util.Arrays;


class QuartoFifthCircleWrapperTest {


    //QuartoFifthCircleWrapper quartoFifthCircleWrapper = Mockito.mock(QuartoFifthCircleWrapper.class);//new QuartoFifthCircleWrapper();

    StrTonalityWrapper wrapper = new StrTonalityWrapper(new QuartoFifthCircle(new NaturalScale(new NaturalScaleCalculator())),
            new TonalityConverterImpl(new TonalityValidatorImpl()));

    Logger logger = Mockito.mock(Logger.class);


    @Test
    void doesntThrow(){
        Assertions.assertDoesNotThrow(()->wrapper.getAsStrings("Am"));
    }

    @Test
    void testCaseAm(){
        String[] chords = new String[]{
                "Am","C","F","G", "Em", "Dm"

        };
        testCase("Am", chords);
    }

    @Test
    void testCaseCm(){
        String[] chords = new String[]{
                "Cm",
                "D#","G#","A#", "Gm", "Fm"
        };
        testCase("Cm", chords);
    }

    void testCase(String chord, String[] testChords){

        String[] chords = wrapper.getAsStrings(chord);

        int i=0;
        for (String s:
             chords) {
            Assertions.assertTrue(Arrays.asList(testChords).contains(s));
        }

    }

    @Test
    void testCaseAdm(){

        String[] chords = new String[]{
                "A#m",
                "C#",
                "D#m",
                "Fm",
                "F#",
                "G#"
        };
        testCase("A#m", chords);

    }

    @Test
    void print(){

        Assertions.assertDoesNotThrow(
                ()->{
                    logger.info(Arrays.toString(wrapper.getAsStrings("Am")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("A#m")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Bm")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Cm")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("C#m")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Dm")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("D#m")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Em")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Fm")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("F#m")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("Gm")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("G#m")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("A")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("A#")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("B")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("C")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("C#")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("D")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("D#")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("E")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("F")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("F#")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("G")));
                    logger.info(Arrays.toString(wrapper.getAsStrings("G#")));
                }
        );

    }

}