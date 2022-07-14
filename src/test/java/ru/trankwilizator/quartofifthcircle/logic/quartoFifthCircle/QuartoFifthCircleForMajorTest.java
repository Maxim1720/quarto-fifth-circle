package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.IQuartoFifthCircle;


class QuartoFifthCircleForMajorTest {


    IQuartoFifthCircle quartoFifthCircle = Mockito.mock(IQuartoFifthCircle.class);//new QuartoFifthCircle();


    /*@BeforeEach
    void init(){
        quartoFifthCircle = new QuartoFifthCircleForMajor();
    }*/

    @Test
    void testCaseC(){
        System.out.println("C");

        Notes[] notes = new Notes[]{
                Notes.F,
                Notes.G,
                Notes.A,
                Notes.E,
                Notes.D
        };
        chordCase(Notes.C, notes);
    }


    @Test
    void testCaseB(){

        System.out.println("B");

        Notes[] notes = new Notes[]{
                Notes.E,
                Notes.Fd,
                Notes.Gd,
                Notes.Dd,
                Notes.Cd
        };

        chordCase(Notes.B, notes);
    }

    private void chordCase(Notes key, Notes[] testNotes){

        /*Chord chord = new Chord(key, Fret.MAJOR);
        Notes[] ns = quartoFifthCircle.getChords(chord);
        for(int i=0;i<ns.length;i++){
            System.out.println(
                    testNotes[i] + " = = " + ns[i]
            );
            Assertions.assertEquals(testNotes[i], ns[i]);
        }*/
    }


}