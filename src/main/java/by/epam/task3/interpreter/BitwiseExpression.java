package by.epam.task3.interpreter;

import java.util.function.Consumer;

@FunctionalInterface
public interface BitwiseExpression extends Consumer<InterpreterContext>{
    @Override
    void accept(InterpreterContext interpreterContext);
}
