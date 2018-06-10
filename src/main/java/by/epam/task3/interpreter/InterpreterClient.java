package by.epam.task3.interpreter;

import java.util.ArrayList;
import java.util.List;

public class InterpreterClient {
    private static final String EXPRESSION_SPLITTER = "\\p{Blank}+";
    private List<BitwiseExpression> expressions = new ArrayList<>();
    private InterpreterContext context = new InterpreterContext();

    public void parse(String expression) {
        ReversePolishNotationParser parser = new ReversePolishNotationParser();
        expression = parser.parse(expression);
        for (String s : expression.split(EXPRESSION_SPLITTER)) {
            if (s.isEmpty()) {
                continue;
            }
            switch (s) {
                case "&":
                    expressions.add(newContext ->
                            context.push(context.pop() & context.pop())
                    );
                    break;
                case "|":
                    expressions.add(newContext ->
                            context.push(context.pop() | context.pop())
                    );
                    break;
                case "^":
                    expressions.add(newContext ->
                            context.push(context.pop() ^ context.pop())
                    );
                    break;
                case "<<":
                    expressions.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 << arg2);
                            }
                    );
                    break;
                case ">>":
                    expressions.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 >> arg2);
                            }
                    );
                    break;
                case ">>>":
                    expressions.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 >>> arg2);
                            }
                    );
                    break;
                case "~":
                    expressions.add(newContext ->
                            context.push(~(context.pop()))
                    );
                    break;
                default:
                    expressions.add(new NonTerminalExpression(Integer.parseInt(s)));
            }
        }
    }

    public int calculate() {
        for (BitwiseExpression expression : expressions) {
            expression.accept(context);
        }
        return context.pop();
    }
}
