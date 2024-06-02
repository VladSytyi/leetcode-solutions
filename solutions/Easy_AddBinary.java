public class Easy_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011")); // 10101
        System.out.println(addBinary("10010", "110")); // 11000
    }

    public static String addBinary(String a, String b) {

        // iterate from the end

        // two pointers

        StringBuilder sb = new StringBuilder();

        int pointerA = a.length() -1 ;
        int pointerB = b.length() -1 ;

        int carry = 0;

        while (pointerA >= 0 || pointerB >= 0) {

            int digit1 = (pointerA >= 0) ? Character.getNumericValue(a.charAt(pointerA)) : 0;
            int digit2 = (pointerB >= 0) ? Character.getNumericValue(b.charAt(pointerB)) : 0;

            int sum = digit1 + digit2 + carry;

            int currentDigit = sum % 2; // result
            carry = sum / 2; // remainder

            sb.append(currentDigit);

            pointerA--;
            pointerB--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        // reverse
        return sb.reverse().toString();
    }

}
