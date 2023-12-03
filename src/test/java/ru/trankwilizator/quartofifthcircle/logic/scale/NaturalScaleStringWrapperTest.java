package ru.trankwilizator.quartofifthcircle.logic.scale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import ru.trankwilizator.quartofifthcircle.logic.NotesToTonalitiesReceiverAdapter;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverterImpl;
import ru.trankwilizator.quartofifthcircle.logic.tonality.validator.TonalityValidatorImpl;
import ru.trankwilizator.quartofifthcircle.logic.scale.calculator.natural.NaturalScaleCalculator;
import ru.trankwilizator.quartofifthcircle.logic.scale.natural.NaturalScale;
import ru.trankwilizator.quartofifthcircle.logic.str_converter.StrTonalityWrapper;

class NaturalScaleStringWrapperTest {

    //NaturalScaleWrapper scaleStringWrapper = Mockito.mock(NaturalScaleWrapper.class);//new ScaleStringWrapper();

    @Test
    void testAm(){
        generalTests("Am", new String[]{
                "A","B","C","D","E","F","G"
        });
    }


    private void generalTests(String key, String[] expected){
        String[] actual = new StrTonalityWrapper(new NotesToTonalitiesReceiverAdapter(new NaturalScale(new NaturalScaleCalculator())),
                new TonalityConverterImpl(new TonalityValidatorImpl())).getAsStrings(key);
        //scaleStringWrapper.getAsStrings(chordStr);

        int i=0;
        for (String s:
             expected) {
            LoggerFactory.getLogger(System.Logger.class).info("expected = " + s + ", actual = " + actual[i]);
            Assertions.assertEquals(s, actual[i++]);
        }


    }


}