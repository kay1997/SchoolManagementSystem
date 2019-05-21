package com.factory.equipment;

import com.domain.equipment.Textbook;

public class TextbookFactory {

    public static Textbook getTextbook(String textbookName, String textbookCode) {
        return new Textbook.Builder().textbookName(textbookName).textbookCode(textbookCode).build();
    }
}
