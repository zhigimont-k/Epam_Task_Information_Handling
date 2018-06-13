package by.epam.task3.action;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.composite.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextAction {

    public TextComponent sortParagraphsBySentenceNumber(TextComponent text) {
        List<TextComponent> paragraphList = findAllParagraphs(text);
        paragraphList.sort(
                Comparator.<TextComponent>comparingInt(o -> o.getComponentList().size())
                        .thenComparing((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.toString(), o2.toString())));
        TextComponent sortedText = new TextComposite(TextComponent.TextComponentType.TEXT);
        for (TextComponent paragraph : paragraphList) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    public TextComponent sortSentencesByLexemeLength(TextComponent text) {
        List<TextComponent> sentenceList = findAllSentences(text);
        sentenceList.sort(Comparator.<TextComponent>comparingInt(o -> o.getComponentList().size())
                .thenComparing((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.toString(), o2.toString())));
        TextComponent sortedText = new TextComposite(TextComponent.TextComponentType.TEXT);
        for (TextComponent sentence : sentenceList) {
            sortedText.add(sentence);
        }
        return sortedText;
    }

    public TextComponent sortLexemesBySymbolOccurrence(char symbol, TextComponent text) {
        List<TextComponent> lexemeList = findAllLexemes(text);
        lexemeList.sort(Comparator.<TextComponent>comparingInt(o -> countCharOccurrence(symbol, o.toString())).reversed()
                .thenComparing((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.toString(), o2.toString())));
        TextComponent sortedText = new TextComposite(TextComponent.TextComponentType.TEXT);
        for (TextComponent lexeme : lexemeList) {
            sortedText.add(lexeme);
        }
        return sortedText;
    }

    private List<TextComponent> findAllParagraphs(TextComponent text) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponentList()) {
            result.add(paragraph);
        }
        return result;
    }

    private List<TextComponent> findAllSentences(TextComponent text) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponentList()) {
            for (TextComponent sentence : paragraph.getComponentList()) {
                result.add(sentence);
            }
        }
        return result;
    }

    private List<TextComponent> findAllLexemes(TextComponent text) {
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponentList()) {
            for (TextComponent sentence : paragraph.getComponentList()) {
                for (TextComponent lexeme : sentence.getComponentList()) {
                    result.add(lexeme);
                }
            }
        }
        return result;
    }

    private int countCharOccurrence(char character, String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                counter++;
            }
        }
        return counter;
    }
}
