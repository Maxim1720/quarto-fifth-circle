package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.glassfish.grizzly.http.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.trankwilizator.quartofifthcircle.logic.Notes;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuartoFifthCircleForMinorTest {

    QuartoFifthCircleForMinor quartoFifthCircleForMinor;

    @BeforeEach
    private void init(){
        quartoFifthCircleForMinor = new QuartoFifthCircleForMinor();
    }

    @Test
    void getChordsDoesntThrowException(){

        Assertions.assertDoesNotThrow(()->{
            quartoFifthCircleForMinor.getChords(Notes.A);
        } );

    }

    @Test
    void testCalculatingAm(){
        Notes[] notes = new Notes[]{
                Notes.C,
                Notes.F,
                Notes.G,
                Notes.E,
                Notes.D
        };
        System.out.println("AM");
        chordCase(Notes.A, notes);
    }

    @Test
    void testCaseCm(){

        Notes[] notes = new Notes[]{
                Notes.Dd,
                Notes.Gd,
                Notes.Ad,
                Notes.G,
                Notes.F
        };
        System.out.println("CM");
        chordCase(Notes.C, notes);
    }


    @Test
    void testCaseAdm() {

        Notes[] notes = new Notes[]{
                Notes.Cd,
                Notes.Fd,
                Notes.Gd,
                Notes.F,
                Notes.Dd
        };
        System.out.println("A#m");
        chordCase(Notes.Ad, notes);
    }

    @Test
    void testCaseEm(){
        Notes[] notes = new Notes[]{
                Notes.G,
                Notes.C,
                Notes.D,
                Notes.B,
                Notes.A
        };
        System.out.println("Em");
        chordCase(Notes.E, notes);
    }

    @Test
    void caseDmIsEquals(){

        Notes[] notes = new Notes[]{
                Notes.F,
                Notes.Ad,
                Notes.C,
                Notes.A,
                Notes.G
        };
        System.out.println("DM");
        chordCase(Notes.D, notes);
    }

    private void chordCase(Notes key, Notes[] testNotes){

        Notes[] ns = quartoFifthCircleForMinor.getChords(key);
        for(int i=0;i<ns.length;i++){
            System.out.println(
                    testNotes[i] + " = = " + ns[i]
            );
            Assertions.assertEquals(testNotes[i], ns[i]);
        }
    }



}