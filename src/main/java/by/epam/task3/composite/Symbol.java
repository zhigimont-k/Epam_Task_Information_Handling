package by.epam.task3.composite;

public class Symbol extends TextComponent {
    private char character;

    private Symbol() {
    }

    public Symbol(char character) {
        this.character = character;
    }

    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException("Can't perform operations on the leaf");
    }

    public Object getChild(int index) {
        throw new UnsupportedOperationException("Can't perform operations on the leaf");
    }

    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException("Can't perform operations on the leaf");
    }

    @Override
    public TextPartType getType() {
        return TextPartType.SYMBOL;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol1 = (Symbol) o;
        return character == symbol1.character;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += hash * 31 + character;
        return hash;
    }
}
