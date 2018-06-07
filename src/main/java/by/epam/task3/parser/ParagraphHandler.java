package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements TextComponentHandler {
    private static final String PARAGRAPH_REGEXP = "\t(.)+$";
    private SentenceHandler sentenceHandler = new SentenceHandler();

    @Override
    public TextComponent parse(String textString) {
        Matcher matcher = Pattern.compile(PARAGRAPH_REGEXP).matcher(textString);
        TextComponent text = new TextComposite(TextComponent.TextPartType.TEXT);
        while (matcher.find()){
            String paragraph = matcher.group();
            TextComponent paragraphComponent = new TextComposite(TextComponent.TextPartType.PARAGRAPH);
            sentenceHandler.parse(paragraph);
            text.add(paragraphComponent);
        }
        return text;
    }
}
