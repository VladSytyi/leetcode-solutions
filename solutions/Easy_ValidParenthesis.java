import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Easy_ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValidParenthesis("{}[]{}[{}])"));
    }

    // Declare CloseToOpenMap
    // if bracket is openning push to the stack
    // if closed , check stack is not empty and than compare values from map
    public static boolean isValidParenthesis(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(')', '(');
        closeToOpenMap.put(']', '[');

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char testChar = charArray[i];
            if (!closeToOpenMap.containsKey(testChar)) {
                stack.push(testChar);
            } else {

                if (stack.isEmpty()) return false;

                Character openChar = closeToOpenMap.get(testChar);

                Character popped = stack.pop();

                if (popped != openChar) return false;

            }

        }

        return stack.isEmpty();


    }
}