package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.Symbol;
import by.epam.task3.composite.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterHandler implements TextComponentHandler {
    private static final String LETTER_REGEXP = "\\p{Alpha}";

    @Override
    public TextComponent parse(String wordString) {
        Matcher matcher = Pattern.compile(LETTER_REGEXP).matcher(wordString);
        TextComponent word = new TextComposite(TextComposite.TextPartType.WORD);
        while (matcher.find()) {
            Symbol symbolComponent = new Symbol(matcher.group().charAt(0), TextComponent.TextPartType.LETTER);
            word.add(symbolComponent);
        }
        return word;
    }
}
