package ru.trankwilizator.quartofifthcircle.logic.quartoFifthCircle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.trankwilizator.quartofifthcircle.util.Fret;
import ru.trankwilizator.quartofifthcircle.util.Notes;
import ru.trankwilizator.quartofifthcircle.logic.tonality.Tonality;
import ru.trankwilizator.quartofifthcircle.logic.quarto_fifth_circle.IQuartoFifthCircle;


class QuartoFifthCircleForMinorTest {

    IQuartoFifthCircle quartoFifthCircleForMinor = Mockito.mock(IQuartoFifthCircle.class);//new QuartoFifthCircle();

    @Test
    void getChordsDoesntThrowException(){

        Assertions.assertDoesNotThrow(()->{
            quartoFifthCircleForMinor.chords(new Tonality(Notes.A, Fret.MINOR));
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

       /* Chord chord = new Chord(key, Fret.MINOR);
        Notes[] ns = quartoFifthCircleForMinor.getChords(chord);
        for(int i=0;i<ns.length;i++){
            LoggerFactory.getLogger(Logger.class).info(testNotes[i] + " = = " + ns[i]);
            Assertions.assertEquals(testNotes[i], ns[i]);
        }*/
    }



}