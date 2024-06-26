import java.util.HashMap;
import java.util.Map;

class Easy_RomanToInteger {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
    which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
     Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     The same principle applies to the number nine, which is written as IX.
     There are six instances where subtraction is used:

     I can be placed before V (5) and X (10) to make 4 and 9.
     X can be placed before L (50) and C (100) to make 40 and 90.
     C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.

    Topic: HashTable, Math, String
    Pattern: nope

     */

    public static void main(String[] args) {
        String s = "III";
        String ss = "LVIII";
        String sss = "MCMXCIV";

        System.out.println(romanToInt(s)); // 3
        System.out.println(romanToInt(ss)); // 58
        System.out.println(romanToInt(sss)); // 1994
    }

    // The idea is very simple -- if the current value is lower than the next --> do difference otherwise add

    public static int romanToInt(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        characterIntegerMap.put('I', 1);
        characterIntegerMap.put('V', 5);
        characterIntegerMap.put('X', 10);
        characterIntegerMap.put('L', 50);
        characterIntegerMap.put('C', 100);
        characterIntegerMap.put('D', 500);
        characterIntegerMap.put('M', 1000);

        int result = 0;

        for(int i = 0; i < s.length() - 1; i++ ) {

            char c = s.charAt(i);
            char nextChar = s.charAt(i + 1);

            int number = characterIntegerMap.get(c);
            int nextNumber = characterIntegerMap.get(nextChar);

            if ( number < nextNumber ) {
                result = result - number;
            } else {
                result = result + number;
            }

        }

        // add last symbol, because we excluded it inside for loop
        result = result + characterIntegerMap.get(s.charAt(s.length() - 1));

        return result;
    }
}