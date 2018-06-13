package by.epam.task3.composite;

import java.util.List;

public class Lexeme implements TextComponent {
    private String string;

    private Lexeme() {
    }

    public Lexeme(String string) {
        this.string = string;
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
    public List<TextComponent> getComponentList() {
        throw new UnsupportedOperationException("Can't perform operations on the leaf");
    }

    @Override
    public TextComponentType getType() {
        return TextComponentType.LEXEME;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme1 = (Lexeme) o;
        return string.equals(lexeme1.string);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += hash * 31 + string.hashCode();
        return hash;
    }
}
