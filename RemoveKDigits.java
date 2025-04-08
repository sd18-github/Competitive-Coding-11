/*
 * TC: O(n)
 * SC: O(n)
 */
import java.util.Stack;

public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            char d = num.charAt(i);
            // when we encounter a digit smaller than the top of
            // the stack, pop until the digit is greater (or k reaches 0)
            while(!stack.isEmpty() && k > 0 && d < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(d);
        }
        // in case k is not yet 0,
        // there are still some more digits to remove
        while(k > 0) {
            stack.pop();
            k--;
        }
        // the stack holds our answer
        // (in reverse)
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        // remove leading 0s
        while(!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
