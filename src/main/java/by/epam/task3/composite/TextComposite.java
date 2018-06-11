package by.epam.task3.composite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class TextComposite extends TextComponent {
    private List<TextComponent> textComponents;
    private static final String WHITE_SPACE = " ";

    public TextComposite() {
        textComponents = new LinkedList<>();
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

    public List<TextComponent> getComponents(){
        return Collections.unmodifiableList(textComponents);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextComponent component : textComponents){
            result.append(component);
            result.append(WHITE_SPACE);
        }
        return result.toString().trim();
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
