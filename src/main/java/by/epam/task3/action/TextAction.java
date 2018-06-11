package by.epam.task3.action;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextAction {

    public TextComponent sortParagraphsBySentenceLength(TextComponent text) {
        List<TextComponent> paragraphList = text.getComponents();
        paragraphList.sort((o1, o2) ->
                o1.getComponents().size() - o2.getComponents().size());
        TextComponent sortedText = new TextComposite();
        for (TextComponent paragraph : paragraphList) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    public TextComponent sortSentencesByLexemeLength(TextComponent text) {
        List<TextComponent> sentenceList = findAllSentences(text);
        sentenceList.sort((o1, o2) ->
                o1.getComponents().size() - o2.getComponents().size());
        TextComponent sortedText = new TextComposite();
        for (TextComponent sentence : sentenceList) {
            sortedText.add(sentence);
        }
        return sortedText;
    }

    public TextComponent sortLexemesBySymbolOccurrence(char symbol, TextComponent text) {
        List<TextComponent> lexemeList = findAllLexemes(text);
        lexemeList.sort((o1, o2) ->
                (int) o1.toString().chars().filter(ch -> ch == symbol).count() -
                        (int) o2.toString().chars().filter(ch -> ch == symbol).count());
        TextComponent sortedText = new TextComposite();
        for (TextComponent lexeme : lexemeList) {
            sortedText.add(lexeme);
        }
        return sortedText;
    }

    private List<TextComponent> findAllSentences(TextComponent text) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                result.add(sentence);
            }
        }
        return result;
    }

    private List<TextComponent> findAllLexemes(TextComponent text) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent lexeme : sentence.getComponents()) {
                    result.add(lexeme);
                }
            }
        }
        return result;
    }
}
