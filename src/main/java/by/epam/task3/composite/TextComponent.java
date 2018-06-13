package by.epam.task3.composite;

import java.util.List;

public interface TextComponent {
    enum TextComponentType{
        TEXT, PARAGRAPH, SENTENCE, LEXEME
    }

    void add(TextComponent textComponent);

    Object getChild(int index);

    void remove(TextComponent textComponent);

    List<TextComponent> getComponentList();

    TextComponentType getType();

}
