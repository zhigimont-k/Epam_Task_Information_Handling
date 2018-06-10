package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler implements TextComponentHandler {
    protected static final String WORD_REGEXP = "\\p{Alpha}+";
    private LetterHandler letterHandler = new LetterHandler();

    @Override
    public TextComponent parse(String lexemeString) {
        Matcher matcher = Pattern.compile(WORD_REGEXP).matcher(lexemeString);
        TextComponent lexeme = new TextComposite(TextComponent.TextPartType.LEXEME);
        while (matcher.find()) {
            String word = matcher.group();
            TextComponent wordComponent = new TextComposite(TextComponent.TextPartType.WORD);
            wordComponent = letterHandler.parse(word);
            lexeme.add(wordComponent);
        }
        return lexeme;
    }
}
