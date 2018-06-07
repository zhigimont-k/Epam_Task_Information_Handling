package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements TextComponentHandler {
    private static final String LEXEME_REGEXP = "[/w]+|[.,?!:;\\-()\\[\\]\\d+]";
    private PunctuationMarkHandler punctuationMarkHandler = new PunctuationMarkHandler();
    private WordHandler wordHandler = new WordHandler();

    @Override
    public TextComponent parse(String sentenceString) {
        Pattern pattern = Pattern.compile(LEXEME_REGEXP);
        Matcher matcher = pattern.matcher(sentenceString);
        TextComponent sentence = new TextComposite(TextComponent.TextPartType.SENTENCE);
        while (matcher.find()) {
            String lexeme = matcher.group();
            if (lexeme.matches(WordHandler.WORD_REGEXP)) {
                TextComponent wordComponent = new TextComposite(TextComponent.TextPartType.WORD);
                wordComponent.add(wordComponent);
                wordHandler.parse(lexeme);
                sentence.add(wordComponent);
            } else {
                TextComponent punctuationMarkComponent = new TextComposite(TextComponent.TextPartType.PUNCTUATION_MARK);
                punctuationMarkComponent.add(punctuationMarkComponent);
                punctuationMarkHandler.parse(lexeme);
                sentence.add(punctuationMarkComponent);
            }
        }
        return sentence;
    }
}
