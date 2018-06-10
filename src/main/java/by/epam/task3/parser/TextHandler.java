package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextHandler implements TextComponentHandler {
    private ParagraphHandler paragraphHandler = new ParagraphHandler();

    @Override
    public TextComponent parse(String string) {
        return paragraphHandler.parse(string);
    }
}
