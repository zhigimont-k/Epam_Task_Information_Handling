package by.epam.task3.interpreter;


import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotationParser {

    private enum BitwiseOperation{
        BRACKET(0), AND(3), OR(1), XOR(2), L_SHIFT(4), R_SHIFT(4), ZERO_R_SHIFT(4), NOT(5);
        private int priority;
        BitwiseOperation(int priority){
            this.priority = priority;
        }
        int getPriority(){
            return priority;
        }
    }

    public String parse(String expression){
        Deque<String> reversePolishNotation = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();
        return new String();
    }
}
