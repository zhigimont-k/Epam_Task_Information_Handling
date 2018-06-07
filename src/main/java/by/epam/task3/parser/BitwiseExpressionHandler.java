package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import by.epam.task3.interpreter.InterpreterClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitwiseExpressionHandler implements TextComponentHandler {
    private static final String BINARY_EXPRESSION_REGEXP = "";

    @Override
    public TextComponent parse(String string) {
        Matcher matcher = Pattern.compile(BINARY_EXPRESSION_REGEXP).matcher(string);
        TextComponent lexeme = new TextComposite(TextComponent.TextPartType.LEXEME);
        while (matcher.find()) {
            String expression = matcher.group();
            TextComponent numberComponent = new TextComposite(TextComponent.TextPartType.NUMBER);
            InterpreterClient interpreter = new InterpreterClient();
            interpreter.parse(expression);
            lexeme.add(numberComponent);
        }
        return lexeme;
    }
}
