package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.Symbol;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterHandler implements TextComponentHandler {
    private static final String LETTER_REGEXP = "\\S";

    @Override
    public TextComponent parse(String wordString) {
        Matcher matcher = Pattern.compile(LETTER_REGEXP).matcher(wordString);
        TextComponent word = new TextComposite(TextComposite.TextPartType.WORD);
        while (matcher.find()) {
            char symbol = matcher.group().charAt(0);
            Symbol symbolComponent = new Symbol(symbol, TextComponent.SymbolType.LETTER);
            word.add(symbolComponent);
        }
        return word;
    }
}
