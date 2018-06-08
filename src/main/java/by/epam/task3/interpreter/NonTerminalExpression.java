package by.epam.task3.interpreter;

public class NonTerminalExpression implements BitwiseExpression {
    private int number;

    NonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void accept(InterpreterContext context) {
        context.push(number);
    }
}
