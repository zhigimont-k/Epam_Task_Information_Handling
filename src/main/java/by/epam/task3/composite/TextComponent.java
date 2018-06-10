package by.epam.task3.composite;

public abstract class TextComponent {
    public enum TextPartType {
        SYMBOL, LETTER, PUNCTUATION_MARK, NUMBER, WORD, LEXEME, SENTENCE, PARAGRAPH, TEXT
    }

    public abstract void add(TextComponent textComponent);

    public abstract Object getChild(int index);

    public abstract void remove(TextComponent textComponent);

    public abstract TextPartType getType();

    public abstract String toString();

}
