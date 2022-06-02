package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.trankwilizator.quartofifthcircle.logic.Notes;

@SpringBootTest
class QuartoFifthCircleForMajorTest {


    QuartoFifthCircle quartoFifthCircle = new QuartoFifthCircleForMajor();


    @BeforeEach
    void init(){
        quartoFifthCircle = new QuartoFifthCircleForMajor();
    }

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

        Notes[] ns = quartoFifthCircle.getChords(key);
        for(int i=0;i<ns.length;i++){
            System.out.println(
                    testNotes[i] + " = = " + ns[i]
            );
            Assertions.assertEquals(testNotes[i], ns[i]);
        }
    }


}