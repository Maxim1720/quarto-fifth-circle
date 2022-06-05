package ru.trankwilizator.quartofifthcircle.logic.exception;

public class ChordException extends RuntimeException{
    public ChordException(String msg){
        super(msg);
    }

    public ChordException(){
        super("Incorrect chord");
    }
}
