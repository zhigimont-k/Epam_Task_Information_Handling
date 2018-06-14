package by.epam.task3.parser;

import by.epam.task3.composite.Lexeme;
import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import by.epam.task3.interpreter.InterpreterClient;
import by.epam.task3.interpreter.ReversePolishNotationParser;

import java.util.Arrays;
import java.util.List;

public class LexemeHandler implements TextComponentHandler {
    private static final String BITWISE_EXPRESSION_REGEXP = "[\\d~^&|<>()]+";
    private static final String LEXEME_DELIMITER = "\\p{Blank}";

    @Override
    public TextComponent parse(String sentenceString) {
        TextComponent sentence = new TextComposite(TextComponent.TextComponentType.SENTENCE);
        List<String> lexemeList = Arrays.asList(sentenceString.split(LEXEME_DELIMITER));
        for (String lexeme : lexemeList) {
            if (lexeme.matches(BITWISE_EXPRESSION_REGEXP)) {
                InterpreterClient interpreter = new InterpreterClient();
                interpreter.parse(new ReversePolishNotationParser().parse(lexeme));
                int expressionResult = interpreter.calculate();
                Lexeme lexemeComponent = new Lexeme(String.valueOf(expressionResult));
                sentence.add(lexemeComponent);
            } else {
                Lexeme lexemeComponent = new Lexeme(lexeme);
                sentence.add(lexemeComponent);
            }
        }
        return sentence;
    }
}
