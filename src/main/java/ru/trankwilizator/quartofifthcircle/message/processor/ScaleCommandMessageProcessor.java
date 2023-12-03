package ru.trankwilizator.quartofifthcircle.message.processor;

import org.springframework.context.support.MessageSourceResourceBundle;
import ru.trankwilizator.quartofifthcircle.message.processor.command.Command;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScaleCommandMessageProcessor extends CommandMessageProcessor {

    public ScaleCommandMessageProcessor(Command command) {
        super(command);
    }

    @Override
    protected String answer(String key) {
        return new StrAnswerBuilder().build(getResultStrings(key));
    }

    private String[] getResultStrings(String key) {
        List<String> res = strings(key);
        int halfSize = res.size()/2;
        res.add(0,
                MessageSourceResourceBundle
                        .getBundle("messages")
                        .getString("bot.command.scale.ascending.caption")+ ':'
        );
        res.add(halfSize+1,
                MessageSourceResourceBundle
                        .getBundle("messages")
                        .getString("bot.command.scale.descending.caption") + ':'
        );
        res.add(halfSize+1, "\n");

        //works in JAVA 18
        /*return res.stream().toArray(
                String[]::new
        );*/

        return res.stream().toArray(
                String[]::new
        );
    }

    private List<String> strings(String key){

        //works in JAVA 18
        /*return new ArrayList<>(Arrays
                .stream(command.execute(key).split("\n"))
                .toList()
        );*/
        return Arrays
                .stream(command.execute(key).split("\n")).collect(Collectors.toList());
    }
}
