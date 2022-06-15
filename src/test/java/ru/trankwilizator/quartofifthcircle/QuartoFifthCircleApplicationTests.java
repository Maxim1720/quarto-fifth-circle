package ru.trankwilizator.quartofifthcircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;


class QuartoFifthCircleApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testChordsCalculatingAm(){

        String chord = "Am";
        ArrayList<String> chords = executeChords(chord);
        String[] chordsStr = new String[]{
                "G","F","Em","Dm","C"
        };
        check(chordsStr, chords);
    }

    //@Test
    void testChordsCalculationCm(){

        String[] testChords = new String[]{
                "B","A",
        };
        ArrayList<String> calculatedChords = executeChords("Cm");
        check(testChords,calculatedChords);

    }

    private void check(String[] testChords, ArrayList<String> calculatedChords){
        int i=0;
        for (String ch:
                calculatedChords) {
            Assertions.assertEquals(testChords[i++], ch);
        }
    }

    public ArrayList<String> executeChords(String chord){
        ArrayList<String> chords = new ArrayList<>();
        int step = 1;
        boolean isMinor = false;
        if(chord.contains("m")){
            step = -1;
            isMinor = true;
        }
        char c = chord.charAt(0);
        for(int i=0;i<5;i++){
            if(i%2==0){
                isMinor = !isMinor;
            }
            String nextChord = nextChord(c,step,isMinor);
            chords.add(nextChord);
            c = nextChord.charAt(0);
        }
        return chords;
    }

    private String nextChord(char firstLetter, int step, boolean minor) {

        if (firstLetter + step > 'G') {
            firstLetter = 'A';
        } else if (firstLetter + step < 'A') {
            firstLetter = 'G';
        }
        else {
            firstLetter+=step;
        }


        String chord = String.valueOf(firstLetter).toUpperCase();
        if (minor) chord += "m";
        return chord;
    }


}
