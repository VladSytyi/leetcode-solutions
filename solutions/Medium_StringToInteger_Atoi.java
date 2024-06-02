public class Medium_StringToInteger_Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("  -33")); // -33
        System.out.println(myAtoi("king 25")); // 0
        System.out.println(myAtoi("79")); // 79
        System.out.println(myAtoi("")); // 0
        System.out.println(myAtoi("+1")); // 1
        System.out.println(myAtoi("-+1")); //
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("+")); // 0
    }

    public static int myAtoi(String s) {

        if (s.isEmpty()) return 0;

        // 1. remove leading white space --> possibly use trim, or iterate and skip spaces -- DONE
        // 2. if '-' -- implies that it is negative, if nothing -- positive, if +- --> return 0;

        // After removing the whitespace, if the first non-space character is not a sign character,
        // '+' or '-', but a non-digit character, i.e., an English letter or the period '.'
        // the function stops processing further and returns 0
        //.

        // if the first non-space character is a sign character, '+' or '-',
        // and the next character is a non-digit character (including the space character), the function returns 0

        //.

        // integer boundaries

        int result = 0;
        int i = 0; // keeps track of characters
        int sign = 1; // positive by default , -1 - if negative

        // trim white spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // check sign character
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {

            // check if negative
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // check is digit

        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {

            // In Java, char is a numeric data type. When you have a char that
            // represents a digit (like '0', '1', '2', etc.),
            // you can subtract the char '0' from it to get the integer value of that digit.

            int digit = s.charAt(i) - '0';  // To get integer value from char

            // check integer overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                // depending on the sign we see whether it is negative or positive overflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;

        }
        //
        return sign * result;
    }
}

