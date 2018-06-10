package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements TextComponentHandler {
    private static final String PARAGRAPH_REGEXP = "(\\t|\\s{4})(.)+$";
    private SentenceHandler sentenceHandler = new SentenceHandler();

    @Override
    public TextComponent parse(String textString) {
        Matcher matcher = Pattern.compile(PARAGRAPH_REGEXP, Pattern.MULTILINE).matcher(textString);
        TextComponent text = new TextComposite(TextComponent.TextPartType.TEXT);
        while (matcher.find()){
            String paragraph = matcher.group();
            TextComponent paragraphComponent = new TextComposite(TextComponent.TextPartType.PARAGRAPH);
            paragraphComponent = sentenceHandler.parse(paragraph.trim());
            text.add(paragraphComponent);
        }
        return text;
    }
}
