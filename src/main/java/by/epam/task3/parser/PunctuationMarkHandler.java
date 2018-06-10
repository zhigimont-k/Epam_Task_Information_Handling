package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.Symbol;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationMarkHandler implements TextComponentHandler {
    protected static final String PUNCTUATION_MARK_REGEXP = "\\p{Punct}";

    @Override
    public TextComponent parse(String lexemeString) {
        Matcher matcher = Pattern.compile(PUNCTUATION_MARK_REGEXP).matcher(lexemeString);
        TextComponent lexeme = new TextComposite(TextComponent.TextPartType.LEXEME);
        while (matcher.find()) {
            Symbol symbolComponent = new Symbol(matcher.group().charAt(0), TextComponent.TextPartType.PUNCTUATION_MARK);
            lexeme.add(symbolComponent);
        }
        return lexeme;
    }
}
