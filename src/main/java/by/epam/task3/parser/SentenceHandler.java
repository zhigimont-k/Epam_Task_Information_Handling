package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements TextComponentHandler {
    private static final String SENTENCE_REGEXP = "\\s*[^.!?]*[.!?]";
    private LexemeHandler lexemeHandler = new LexemeHandler();

    @Override
    public TextComponent parse(String paragraphString) {
        Matcher matcher = Pattern.compile(SENTENCE_REGEXP).matcher(paragraphString);
        TextComponent paragraph = new TextComposite(TextComponent.TextComponentType.PARAGRAPH);
        while (matcher.find()){
            String sentence = matcher.group();
            TextComponent sentenceComponent = lexemeHandler.parse(sentence.trim());
            paragraph.add(sentenceComponent);
        }
        return paragraph;
    }
}
