package ru.trankwilizator.quartofifthcircle.command.message;

public class CommandMessageHandlerMediator {

    private static CommandMessageHandler messageHandler;

    public static void setMessageHandler(CommandMessageHandler handler){
        messageHandler = handler;
    }
    public static CommandMessageHandler getMessageHandler(){
        return messageHandler;
    }

}
