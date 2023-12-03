package ru.trankwilizator.quartofifthcircle.message.processor.command;

import ru.trankwilizator.quartofifthcircle.logic.TonalitiesReceiver;
import ru.trankwilizator.quartofifthcircle.logic.tonality.converter.TonalityConverter;
import ru.trankwilizator.quartofifthcircle.logic.str_converter.StrTonalityWrapper;
import ru.trankwilizator.quartofifthcircle.util.StrAnswerBuilder;

public abstract class AbsCommand implements Command{
    private final StrTonalityWrapper strTonalityWrapper;

    public AbsCommand(TonalitiesReceiver tonalitiesReceiver, TonalityConverter tonalityConverter){
        strTonalityWrapper = new StrTonalityWrapper(tonalitiesReceiver, tonalityConverter);
    }

    @Override
    public String execute(String key) {
        return new StrAnswerBuilder().build(strTonalityWrapper.getAsStrings(key));
    }
}
