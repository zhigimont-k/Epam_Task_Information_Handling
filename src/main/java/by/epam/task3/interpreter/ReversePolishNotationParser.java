package by.epam.task3.interpreter;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ReversePolishNotationParser {
    private static Logger logger = LogManager.getLogger();
    private static final String NUMBER_PATTERN = "\\d+";

    private enum BitwiseOperation {
        BRACKET("(", 0), AND("&", 3), OR("|", 1), XOR("^", 2), L_SHIFT("<", 4), R_SHIFT(">", 4),
        ZERO_R_SHIFT("Z", 4), NOT("~", 5);
        private String string;
        private int priority;

        BitwiseOperation(String string, int priority) {
            this.string = string;
            this.priority = priority;
        }
        public static BitwiseOperation findOperation(String text) {
            return Arrays.stream(values())
                    .filter(bl -> bl.string.equalsIgnoreCase(text))
                    .findFirst()
                    .orElse(BRACKET);
        }

        int getPriority(){
            return priority;
        }
    }

    public String parse(String expression) {
        logger.log(Level.INFO, "Parsing expression: " + expression);
        expression = replaceOperatorsWithSymbols(expression);
        StringBuilder result = new StringBuilder();
        Deque<String> operators = new ArrayDeque<>();
        int expressionLength = expression.length();
        for (int i = 0; i < expressionLength; i++) {
            String symbol = String.valueOf(expression.charAt(i));
            if (String.valueOf(symbol).matches(NUMBER_PATTERN)) {
                result.append(symbol);
                if (i < expressionLength - 1 && !String.valueOf(expression.charAt(i+1)).matches(NUMBER_PATTERN)){
                    result.append(" ");
                }
            } else if ("(".equals(symbol)) {
                operators.push(String.valueOf(symbol));
            } else if (")".equals(symbol)) {
                while (!"(".equals(operators.peek())) {
                    result.append(operators.pop());
                    result.append(" ");
                }
                operators.pop();
            } else {
                BitwiseOperation operation = BitwiseOperation.findOperation(symbol);
                BitwiseOperation operationOnStackTop = BitwiseOperation.findOperation(operators.peek());
                while (!operators.isEmpty() && operation.getPriority() <= operationOnStackTop.getPriority()) {
                    result.append(operators.pop());
                    result.append(" ");
                }
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty()) {
            result.append(" ");
            result.append(operators.pop());

        }
        String resultingString = replaceSymbolsWithOperators(result.toString());
        resultingString = resultingString.replaceAll("\\s+", " ");
        logger.log(Level.INFO, "RPN expression: " + resultingString);
        return resultingString;
    }

    private String replaceOperatorsWithSymbols(String expression) {
        expression = expression.replaceAll("<<", "<");
        expression = expression.replaceAll(">>>", "Z");
        expression = expression.replaceAll(">>", ">");
        return expression;
    }

    private String replaceSymbolsWithOperators(String expression) {
        expression = expression.replaceAll("<", "<<");
        expression = expression.replaceAll(">", ">>");
        expression = expression.replaceAll("Z", ">>>");
        return expression;
    }
}
