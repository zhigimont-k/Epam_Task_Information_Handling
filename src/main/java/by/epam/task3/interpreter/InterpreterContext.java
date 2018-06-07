package by.epam.task3.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class InterpreterContext {
    private Deque<Integer> values = new ArrayDeque<>();

    public Integer pop() {
        return values.pop();
    }

    public void push(Integer value) {
        values.push(value);
    }
}
