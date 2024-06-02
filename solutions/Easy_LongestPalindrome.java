import java.util.HashMap;
import java.util.Map;

public class Easy_LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); // 7
        System.out.println(longestPalindrome("opinion")); // 7
        System.out.println(longestPalindrome("GooooooOOOOODdddD")); // 15
       // System.out.println(longestPalindrome("a")); // 1

    }

    // The idea is to iterate over the input string and calculate the occurrence of character
    // 2. Iterate over Frequencies Map
    // if character is even --> add to the length
    // if character is odd --> add to length, but minus one , because it could be 1, 3, 5

    // 3. compare derived length with the original
    // if length < original add 1;
    // of length > original --> do nothing


    public static int longestPalindrome(String s) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> frequency = new HashMap<>();
        int length = 0;

        char[] chars = s.toCharArray();

        for (int i = 0 ; i < chars.length; i++) {

            if (frequency.containsKey(chars[i])) {
                Integer value = frequency.get(chars[i]);
                frequency.put(chars[i], ++value);
            } else {
                frequency.put(chars[i], 1);
            }
        }

        for (Integer value : frequency.values()) {

            if (value % 2 == 0) {
                length = length + value;
            } else {
                length = length + value - 1;
            }
        }

        if (length < s.length()) {
            length = length + 1;
        }

        return length;
    }
}
