package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.context.support.MessageSourceResourceBundle;
import ru.trankwilizator.quartofifthcircle.logic.wrapper.StrWrapper;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CustomScaleCommand<T> extends Command<T>{

    protected CustomScaleCommand(StrWrapper<T> wrapper,
                                 StrAnswerBuilder strAnswerBuilder) {
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
        return toArray(res);
    }

    private String[] toArray(List<String> list){
        int i=0;
        String[] arr = new String[list.size()];
        for (String s:
                list) {
            arr[i++] = s;
        }
        return arr;
    }

}
