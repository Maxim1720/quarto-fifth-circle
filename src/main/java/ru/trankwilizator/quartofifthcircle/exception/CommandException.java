package ru.trankwilizator.quartofifthcircle.exception;

public class CommandException extends RuntimeException{

    public CommandException(String commandName){
        super("Incorrect command: " +  commandName);
    }
}
