import java.util.List;
import java.util.Stack;

class Medium_ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(rpn(List.of("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+").toArray(new String[0])));
    }

    public static int rpn(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }

        }

        return stack.pop();

    }
}