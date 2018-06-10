package by.epam.task3.parser;

import by.epam.task3.composite.Symbol;
import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberHandler implements TextComponentHandler {
    private static Logger logger = LogManager.getLogger();
    private static final String NUMBER_REGEXP = "\\d";

    @Override
    public TextComponent parse(String lexemeString) {
        Matcher matcher = Pattern.compile(NUMBER_REGEXP).matcher(lexemeString);
        TextComponent lexeme = new TextComposite(TextComposite.TextPartType.LEXEME);
        while (matcher.find()) {
            logger.log(Level.INFO, "Parsing a number: "+lexemeString);
            Symbol symbolComponent = new Symbol(matcher.group().charAt(0), TextComponent.TextPartType.NUMBER);
            logger.log(Level.INFO, "Adding a number: "+symbolComponent);
            lexeme.add(symbolComponent);
        }
        return lexeme;
    }
}
