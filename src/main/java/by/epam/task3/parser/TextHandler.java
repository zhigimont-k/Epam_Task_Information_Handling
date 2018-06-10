package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;

public class TextHandler implements TextComponentHandler {
    private ParagraphHandler paragraphHandler = new ParagraphHandler();

    @Override
    public TextComponent parse(String string) {
        return paragraphHandler.parse(string);
    }
}
