package by.epam.task3.composite;

import java.util.LinkedList;
import java.util.List;

public class TextComposite extends TextComponent implements CharSequence {
    private List<TextComponent> textComponents;
    private TextPartType type;
    private static final String WHITE_SPACE = " ";
    private static final String NEW_LINE = "\n";

    public TextComposite(TextPartType type) {
        textComponents = new LinkedList<>();
        this.type = type;
    }

    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    public Object getChild(int index) {
        return textComponents.get(index);
    }

    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public TextPartType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        //result = String.join(WHITE_SPACE, textComponents);
        for (TextComponent textComponent : textComponents) {
            switch (textComponent.getType()) {
                case LETTER:
                    result.append(textComponent.toString());
                    break;
                case PUNCTUATION_MARK:
                case WORD:
                case LEXEME:
                case SENTENCE:
                    result.append(textComponent.toString() + WHITE_SPACE);
                    break;
                case PARAGRAPH:
                    result.append(textComponent.toString() + NEW_LINE);
                    break;
                default:
                    result.append(textComponent.toString());
                    break;
            }
        }
        return result.toString();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite textComposite = (TextComposite) o;
        int size = textComponents.size();
        if (size != textComposite.textComponents.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!textComponents.get(i).equals(textComposite.textComponents.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (TextComponent textComponent : textComponents) {
            hash += hash * 31 + textComponent.hashCode();
        }
        return hash;
    }
}
