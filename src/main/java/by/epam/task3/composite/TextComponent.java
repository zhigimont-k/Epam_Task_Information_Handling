package by.epam.task3.composite;

public abstract class TextComponent {
    public enum TextPartType {
        SYMBOL, LEXEME, WORD, SENTENCE, PARAGRAPH, TEXT
    }

    public enum SymbolType{
        LETTER, PUNCTUATION_MARK, NUMBER
    }

    public abstract void add(TextComponent textComponent);

    public abstract Object getChild(int index);

    public abstract void remove(TextComponent textComponent);

    public abstract TextPartType getType();

    public abstract String toString();

}
