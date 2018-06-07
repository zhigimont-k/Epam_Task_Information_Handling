package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.Symbol;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationMarkHandler implements TextComponentHandler {
    private static final String PUNCTUATION_MARK_REGEXP = "[.,?!:;\\-()\\[\\]]";

    @Override
    public TextComponent parse(String lexemeString) {
        Matcher matcher = Pattern.compile(PUNCTUATION_MARK_REGEXP).matcher(lexemeString);
        TextComponent lexeme = new TextComposite(TextComponent.TextPartType.LEXEME);
        while (matcher.find()) {
            char symbol = matcher.group().charAt(0);
            Symbol symbolComponent = new Symbol(symbol);
            lexeme.add(symbolComponent);
        }
        return lexeme;
    }
}
