import java.util.Stack;

class Medium_ReversePolishNotation {
    public static void main(String[] args) {
        
    }

    public static int rpn(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (token.matches("\\d+")) {
                stack.push(Integer.valueOf(token));
            } else if (token.equals("+")) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                int res = i1 + i2;
                stack.push(res);
            } else if (token.equals("-")) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                int res = i2 - i1;
                stack.push(res);
            } else if (token.equals("*")) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                int res = i2 * i1;
                stack.push(res);
            } else if (token.equals("/")) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                int res = i2 / i1;
                stack.push(res);
            }

        }

        return stack.pop();

    }
}