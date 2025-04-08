import java.util.Stack;

public class EvaluateRPN {
    /**
     * Determines if token is an operator
     */
    boolean isOperator(String token) {
        return switch (token) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }
    /**
     * Operates on two operands using operator
     * @return value of result as a String
     */
    String operate(String operator, String o1, String o2) {
        int n1 = Integer.parseInt(o1);
        int n2 = Integer.parseInt(o2);
        return switch (operator) {
            case "+" -> String.valueOf(n2 + n1);
            case "-" -> String.valueOf(n2 - n1);
            case "*" -> String.valueOf(n2 * n1);
            case "/" -> String.valueOf(n2 / n1);
            default -> "";
        };
    }
    public int evalRPN(String[] tokens) {
        Stack<String> opStack = new Stack<>();
        for(String token: tokens) {
            // if the token is an operator,
            // operate on the two operands atop the Stack
            // and push the result back onto the Stack
            if(isOperator(token)) {
                String operand = operate(token, opStack.pop(), opStack.pop());
                opStack.push(operand);
            }
            // if the token is an operand, push it onto the Stack
            else {
                opStack.push(token);
            }
        }
        return Integer.parseInt(opStack.pop());
    }
}
