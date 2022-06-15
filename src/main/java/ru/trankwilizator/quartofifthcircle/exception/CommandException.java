package ru.trankwilizator.quartofifthcircle.exception;

public class CommandException extends RuntimeException{

    public CommandException(String commandText){
        super("Incorrect command: " +  commandText);
    }
}
