import java.util.Arrays;
import java.util.Stack;

class Medium_MinStack {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2


        // at the end of file there is a solution which is faster tahtn mine.
        // my solution takes 28ms whether enhanced takes 8ms...
    }

    static class MinStack {

        private int minValue;
        private int[] array;

        int elementsCount;


        public MinStack() {
            this.minValue = Integer.MAX_VALUE;
            this.array = new int[0];
            this.elementsCount = 0;
        }

        public void push(int val) {

            if (val < minValue) {
                minValue = val;
            }

            if (array.length == 0) {
                array = new int[]{val};
                elementsCount++;
                return;
            }

            int[] temp = new int[array.length + 1];

            temp[0] = val;

            for (int i = 1; i <= array.length; i++) {
                temp[i] = array[i - 1];
            }

            elementsCount++;
            array = temp;

        }

        public void pop() {
            // remove and make array shorter
            if (elementsCount == 0) throw new RuntimeException("empty stack");
            array = Arrays.copyOfRange(array, 1, elementsCount);

            elementsCount--;
            // recalculate min value;
            // find min and assign it

            int tempMin = Integer.MAX_VALUE;

            for (int i = 0; i < array.length; i++) {
                if (array[i] < tempMin) {
                    tempMin = array[i];
                }
            }

            minValue = tempMin;

        }

        public int top() {
            if (elementsCount == 0) throw new RuntimeException("empty stack");

            return array[0];
        }

        public int getMin() {
            return minValue;
        }

    }


    static class EnhancedMinStack {
        /* The idea is to modificate usual Java stack and use Pair structure
            Pair will contain val - as an element of stack
            and
            minVal -- min element of stack with current element
        * */

        Stack<Pair> minStack;

        public EnhancedMinStack() {
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            if (minStack.isEmpty()) {
                minStack.push(new Pair(val, val));
            } else {
                int min = Math.min(val, minStack.peek().minVal);
                minStack.push(new Pair(val, min));
            }
        }

        public void pop() {
            minStack.pop();
        }

        public int top() {
            return minStack.peek().val;
        }

        public int getMin() {
            return minStack.pop().minVal;
        }
    }

    private static class Pair {
        int val;
        int minVal;

        public Pair(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


}