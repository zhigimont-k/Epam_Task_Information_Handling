package by.epam.task3.composite;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class TextComposite extends TextComponent {
    private static Logger logger = LogManager.getLogger();
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
        for (TextComponent component : textComponents) {
            if (component.getType().equals(TextPartType.WORD) || "-".equals(component.toString())) {
                result.append(WHITE_SPACE);
                result.append(component);
            } else if (component.getType().equals(TextPartType.PARAGRAPH)) {
                result.append(component);
                result.append(NEW_LINE);
            } else {
                result.append(component);
            }
        }
        return result.toString();
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
