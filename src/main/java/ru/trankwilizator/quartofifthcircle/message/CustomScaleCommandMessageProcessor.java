package ru.trankwilizator.quartofifthcircle.message;

import org.springframework.context.support.MessageSourceResourceBundle;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.IStrWrapper;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomScaleCommandMessageProcessor extends CommandMessageProcessor{

    public CustomScaleCommandMessageProcessor(IStrWrapper wrapper, StrAnswerBuilder strAnswerBuilder) {
        super(wrapper, strAnswerBuilder);
    }

    @Override
    protected String[] getResultStrings(String tonality) {
        ArrayList<String> res = new ArrayList<>(Arrays
                .stream(wrapper()
                        .getAsStrings(tonality))
                .toList()
        );
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
        return res.stream().toArray(
                String[]::new
        );
    }
}
