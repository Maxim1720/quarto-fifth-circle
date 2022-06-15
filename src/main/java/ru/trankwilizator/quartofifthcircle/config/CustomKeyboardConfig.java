package ru.trankwilizator.quartofifthcircle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomKeyboardConfig {

    private final KeyboardRow keyboardRow;

    public CustomKeyboardConfig(){
        keyboardRow = new KeyboardRow();
    }

    @Bean
    public ReplyKeyboardMarkup modeSetKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(buttons());
        return replyKeyboardMarkup;
    }

    private List<KeyboardRow> buttons(){
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        setButtonWithTitleToRow("Quarto Fifth Circle");
        setButtonWithTitleToRow("Scale's Notes");
        keyboardRowList.add(this.keyboardRow);
        return keyboardRowList;
    }

    private void setButtonWithTitleToRow(String title){
        KeyboardButton button = new KeyboardButton();
        button.setText(title);
        keyboardRow.add(button);
    }

}
