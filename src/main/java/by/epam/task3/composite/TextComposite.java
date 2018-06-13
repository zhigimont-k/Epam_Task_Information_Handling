package by.epam.task3.composite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class TextComposite implements TextComponent {
    private List<TextComponent> componentList = new LinkedList<>();
    private TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    public void add(TextComponent textComponent) {
        componentList.add(textComponent);
    }

    public Object getChild(int index) {
        return componentList.get(index);
    }

    public void remove(TextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    public List<TextComponent> getComponentList(){
        return Collections.unmodifiableList(componentList);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextComponent component : componentList){
            result.append(component);
            if (component.getType() == TextComponentType.PARAGRAPH){
                result.append("\n");
            } else {
                result.append(" ");
            }
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
        int size = componentList.size();
        if (size != textComposite.componentList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!componentList.get(i).equals(textComposite.componentList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (TextComponent textComponent : componentList) {
            hash += hash * 31 + textComponent.hashCode();
        }
        return hash;
    }
}
