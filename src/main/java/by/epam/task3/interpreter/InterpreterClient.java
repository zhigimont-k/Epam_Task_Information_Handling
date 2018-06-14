package by.epam.task3.interpreter;

import java.util.LinkedList;
import java.util.List;

public class InterpreterClient {
    private static final String EXPRESSION_SPLITTER = "\\p{Blank}+";
    private List<BitwiseExpression> expressionList = new LinkedList<>();
    private InterpreterContext context = new InterpreterContext();

    public void parse(String expression) {
        for (String s : expression.split(EXPRESSION_SPLITTER)) {
            if (s.isEmpty()) {
                continue;
            }
            switch (s) {
                case "&":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 & arg2);
                            }
                    );
                    break;
                case "|":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 | arg2);
                            }
                    );
                    break;
                case "^":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 ^ arg2);
                            }
                    );
                    break;
                case "<<":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 << arg2);
                            }
                    );
                    break;
                case ">>":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 >> arg2);
                            }
                    );
                    break;
                case ">>>":
                    expressionList.add(newContext -> {
                                int arg2 = context.pop();
                                int arg1 = context.pop();
                                context.push(arg1 >>> arg2);
                            }
                    );
                    break;
                case "~":
                    expressionList.add(newContext ->
                            context.push(~(context.pop()))
                    );
                    break;
                default:
                    expressionList.add(new NonTerminalExpression(Integer.parseInt(s)));
            }
        }
    }

    public int calculate() {
        for (BitwiseExpression expression : expressionList) {
            expression.accept(context);
        }
        return context.pop();
    }
}
