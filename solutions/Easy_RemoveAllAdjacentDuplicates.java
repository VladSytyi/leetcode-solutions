import java.util.Stack;

class Easy_RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {

        System.out.println(removeDuplicates("ggaabcdeb"));
    }

    // 1. Init stack
    // 2. If stack is empty() -- simply put smth inside
    // 3. If not empty --> peek and compare --> of equal --> remove element
    // 4. if all conditions passed --> simply push to the stack
    // 5. At the end init StringBuilder to convert stack into String
    // 6. Remember that to build string from stack you need to Revert!!!


    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = s.toCharArray();


        for (int i = 0; i < charArray.length; i++) {

            if (stack.isEmpty()) {
                stack.push(charArray[i]);
                continue;
            }

            if (stack.peek() == charArray[i]) {
                stack.pop();
                continue;
            }

            stack.push(charArray[i]);


        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();

    }


}