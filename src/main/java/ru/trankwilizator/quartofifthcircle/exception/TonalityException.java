package ru.trankwilizator.quartofifthcircle.exception;

public class TonalityException extends RuntimeException{
    public TonalityException(String msg){
        super(msg);
    }

    public TonalityException(){
        super("Incorrect chord");
    }
}
