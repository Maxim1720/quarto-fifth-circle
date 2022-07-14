package ru.trankwilizator.quartofifthcircle.command.strings;

import org.springframework.stereotype.Component;

@Component
public class StrAnswerBuilder {
    public String build(String[] strings){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:
                strings) {
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }
}
