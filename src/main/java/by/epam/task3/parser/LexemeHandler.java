package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import by.epam.task3.interpreter.InterpreterClient;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements TextComponentHandler {
    private static Logger logger = LogManager.getLogger();
    private static final String LEXEME_REGEXP = "\\p{Alpha}+|[\\d~^&|<>()]+|\\p{Punct}";
    private PunctuationMarkHandler punctuationMarkHandler = new PunctuationMarkHandler();
    private WordHandler wordHandler = new WordHandler();
    private NumberHandler numberHandler = new NumberHandler();

    @Override
    public TextComponent parse(String sentenceString) {
        Matcher matcher = Pattern.compile(LEXEME_REGEXP).matcher(sentenceString);
        TextComponent sentence = new TextComposite(TextComponent.TextPartType.SENTENCE);
        while (matcher.find()) {
            String lexeme = matcher.group();
            logger.log(Level.INFO, "Parsing lexeme: " + lexeme);
            if (lexeme.matches(WordHandler.WORD_REGEXP)) {
                TextComponent wordComponent = new TextComposite(TextComponent.TextPartType.WORD);
                wordComponent = wordHandler.parse(lexeme);
                sentence.add(wordComponent);
            } else if (lexeme.matches(PunctuationMarkHandler.PUNCTUATION_MARK_REGEXP)) {
                TextComponent punctuationMarkComponent = new TextComposite(TextComponent.TextPartType.SYMBOL);
                punctuationMarkComponent = punctuationMarkHandler.parse(lexeme);
                sentence.add(punctuationMarkComponent);
            } else {
                TextComponent numberComponent = new TextComposite(TextComponent.TextPartType.SYMBOL);
                InterpreterClient interpreter = new InterpreterClient();
                interpreter.parse(lexeme);
                int expressionResult = interpreter.calculate();
                numberComponent = numberHandler.parse(String.valueOf(expressionResult));
                sentence.add(numberComponent);
            }
        }
        return sentence;
    }
}
