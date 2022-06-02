package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
class QuartoFifthCircleWrapperTest {

    @Autowired
    QuartoFifthCircleWrapper quartoFifthCircleWrapper;


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


        /*Notes[] notes = new Notes[]{
                Notes.Cd,
                Notes.Fd,
                Notes.Gd,
                Notes.F,
                Notes.Dd
        };
        System.out.println("A#m");*/
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
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Am")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("A#m")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Bm")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Cm")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("C#m")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Dm")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("D#m")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Em")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Fm")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("F#m")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("Gm")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("G#m")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("A")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("A#")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("B")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("C")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("C#")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("D")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("D#")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("E")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("F")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("F#")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("G")));
                    System.out.println(Arrays.toString(quartoFifthCircleWrapper.getChords("G#")));
                }
        );

    }

}