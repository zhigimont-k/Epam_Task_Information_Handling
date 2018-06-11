package by.epam.task3.composite;

import java.util.List;

public abstract class TextComponent {

    public abstract void add(TextComponent textComponent);

    public abstract Object getChild(int index);

    public abstract void remove(TextComponent textComponent);

    public abstract List<TextComponent> getComponents();

}
